package cooperation.qzone.contentbox;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

public class MsgFootTips
  extends FrameLayout
{
  public static final int BEFORE_COMMENT = 2;
  public static final int EVENT_LOAD_MORE_MANUAL = -10000;
  public static final int EVENT_LOAD_MORE_UP_MANUAL = -10001;
  public static final int HIDE = 3;
  public static final int LOADING_DATA = 0;
  public static final int LOADING_MORE_DATA = 1;
  public static final int LOAD_MORE_MANUAL = 5;
  public static final int NO_DATA = 2;
  public static final int NO_MORE_DATA = 4;
  public static final int NO_MORE_DATA_INVISIABLE = 6;
  public static final int NO_MORE_DATA_VISIABLE = 7;
  private static final String TAG = "QZoneMsgManager.MsgFootTips";
  private View commentTipsDivider;
  private ProgressBar commentTipsProgressBar;
  private TextView commentTipsText;
  private LinearLayout commentTipsView;
  private int currentState;
  private MsgFootTips instance = this;
  public boolean isLoadMoreUpHeader;
  private boolean isNoMoreDataVisibility;
  private String loadMoreManualText = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewLookUp", "查看更多");
  private String loadingDataText = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewLoadingComment", "正在加载评论...");
  private String loadingMoreDataText = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewLoadingMoreComment", "加载更多评论...");
  private Context mContext;
  private Handler mHandler;
  private String noDataText = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewAddFirstComment", "快来添加第一条评论吧!");
  private String noMoreDataText = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewShowAll", "已显示全部");
  
  public MsgFootTips(Context paramContext, Handler paramHandler)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    initView();
    bindEvents();
  }
  
  private void bindEvents()
  {
    this.commentTipsView.setOnClickListener(new MsgFootTips.1(this));
  }
  
  private void initView()
  {
    this.commentTipsView = ((LinearLayout)LayoutInflater.from(this.mContext).inflate(2131562311, null));
    try
    {
      this.commentTipsView.setBackgroundResource(2130838911);
      addView(this.commentTipsView);
      this.commentTipsProgressBar = ((ProgressBar)this.commentTipsView.findViewById(2131364912));
      this.commentTipsText = ((TextView)this.commentTipsView.findViewById(2131364913));
      this.commentTipsDivider = this.commentTipsView.findViewById(2131364909);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QZoneMsgManager.MsgFootTips", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public View getFooterRootView()
  {
    return this.commentTipsView;
  }
  
  public int getState()
  {
    return this.currentState;
  }
  
  public boolean isLoading()
  {
    return (this.currentState == 0) || (this.currentState == 1);
  }
  
  public boolean loadMoreAble()
  {
    return this.currentState == 5;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (this.commentTipsView != null) {
      this.commentTipsView.setBackgroundColor(paramInt);
    }
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    View localView = this.commentTipsDivider;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setLoadingDataText(String paramString)
  {
    this.loadingDataText = paramString;
  }
  
  public void setLoadingMoreDataText(String paramString)
  {
    this.loadingMoreDataText = paramString;
  }
  
  public void setNoDataText(String paramString)
  {
    this.noDataText = paramString;
  }
  
  public void setNoMoreDataText(String paramString)
  {
    this.noMoreDataText = paramString;
  }
  
  public void setNoMoreDataVisibility(boolean paramBoolean)
  {
    this.isNoMoreDataVisibility = paramBoolean;
  }
  
  public void setState(int paramInt)
  {
    if ((this.commentTipsText == null) || (this.commentTipsProgressBar == null)) {
      return;
    }
    setVisibility(0);
    this.currentState = paramInt;
    if (this.commentTipsText.getVisibility() == 8) {
      this.commentTipsText.setVisibility(0);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.loadingDataText);
      this.commentTipsProgressBar.setVisibility(0);
      this.commentTipsText.setText(this.loadingDataText);
      this.commentTipsText.setVisibility(0);
      return;
    case 1: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.loadingMoreDataText);
      this.commentTipsProgressBar.setVisibility(0);
      this.commentTipsText.setText(this.loadingMoreDataText);
      this.commentTipsText.setVisibility(0);
      return;
    case 2: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.noDataText);
      this.commentTipsProgressBar.setVisibility(8);
      this.commentTipsText.setText(this.noDataText);
      this.commentTipsText.setVisibility(0);
      return;
    case 3: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，隐藏");
      setVisibility(8);
      this.commentTipsText.setVisibility(8);
      this.commentTipsProgressBar.setVisibility(8);
      return;
    case 4: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.noMoreDataText);
      this.commentTipsProgressBar.setVisibility(8);
      this.commentTipsText.setText(this.noMoreDataText);
      if (this.isNoMoreDataVisibility)
      {
        this.commentTipsText.setVisibility(0);
        return;
      }
      this.commentTipsText.setVisibility(8);
      setVisibility(8);
      return;
    case 6: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.noMoreDataText);
      this.commentTipsProgressBar.setVisibility(8);
      this.commentTipsText.setText(this.noMoreDataText);
      this.commentTipsText.setVisibility(0);
      setVisibility(4);
      return;
    case 7: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.noMoreDataText);
      this.commentTipsProgressBar.setVisibility(8);
      this.commentTipsText.setText(this.noMoreDataText);
      this.commentTipsText.setVisibility(0);
      setVisibility(0);
      return;
    }
    QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.loadMoreManualText);
    this.commentTipsProgressBar.setVisibility(8);
    this.commentTipsText.setText(this.loadMoreManualText);
    this.commentTipsText.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgFootTips
 * JD-Core Version:    0.7.0.1
 */
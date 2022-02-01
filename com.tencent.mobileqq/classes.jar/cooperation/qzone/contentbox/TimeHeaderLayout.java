package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.vip.VipReporterManager;
import mqq.app.AppRuntime;

public class TimeHeaderLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static String KEY_TIME_CAPSULE_EXPAND = "capsule_open";
  ImageView avatarView;
  Handler handler;
  TimeHeaderLayout.HeadInfo headInfo;
  TextView loginDaysView;
  private Context mContext;
  private LinearLayout mLayoutVisitor;
  TimeHeaderLayout.OnDetailClickListner onDetailClickListner;
  SharedPreferences preferences;
  TextView registerDyasView;
  View timeCapsule;
  TextView vistorView;
  
  public TimeHeaderLayout(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public TimeHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public TimeHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private String getCurrentUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  private String getVisitorJumpUrl()
  {
    Object localObject2 = QzoneConfig.getInstance().getConfig("H5Url", "QzoneVisitor", "https://h5.qzone.qq.com/qzone/visitor/{hostUin}?uin={uin}&from={from}&qua={qua}&clicktime={clicktime}&hostuin={hostUin}&_wv=3&_proxy=1&trace_detail=%7B%22appid%22%3A%22{refer}%22%7D");
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return localObject2;
    }
    String str = getCurrentUin();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str)) {
      localObject1 = ((String)localObject2).replace("{uin}", str).replace("{hostUin}", str);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("");
    return ((String)localObject1).replace("{clicktime}", ((StringBuilder)localObject2).toString()).replace("{from}", "androidQQ").replace("{qua}", QUA.getQUA3());
  }
  
  private void init()
  {
    this.handler = new Handler(Looper.getMainLooper());
    LayoutInflater.from(getContext()).inflate(2080636947, this, true);
    this.preferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_time_capsule", 0);
    this.timeCapsule = findViewById(2080571524);
    this.avatarView = ((ImageView)findViewById(2080571397));
    this.registerDyasView = ((TextView)findViewById(2080571499));
    this.loginDaysView = ((TextView)findViewById(2080571494));
    this.vistorView = ((TextView)findViewById(2080571500));
    this.mLayoutVisitor = ((LinearLayout)findViewById(2080571462));
    this.mLayoutVisitor.setOnClickListener(this);
    findViewById(2080571524).setOnClickListener(this);
    VipReporterManager.a(9, 1);
  }
  
  private void onDetailClick(TimeHeaderLayout.HeadInfo paramHeadInfo)
  {
    Object localObject = new LpReportInfo_dc02880(7, 3);
    LpReportManager.getInstance().reportToDC02880((LpReportInfo_dc02880)localObject, false, true);
    localObject = this.onDetailClickListner;
    if ((localObject != null) && (paramHeadInfo != null)) {
      ((TimeHeaderLayout.OnDetailClickListner)localObject).onDetailClick(paramHeadInfo.jumpUrl, 2080571524);
    }
  }
  
  private void update()
  {
    Object localObject = FaceDrawable.getDefaultDrawable(1, 3);
    localObject = FaceDrawable.getFaceDrawable(((BaseActivity)this.mContext).app, 1, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 3, (Drawable)localObject, (Drawable)localObject, null);
    this.avatarView.setImageDrawable((Drawable)localObject);
    localObject = this.headInfo;
    if (localObject != null)
    {
      if (((TimeHeaderLayout.HeadInfo)localObject).todayVisitor > 999L) {
        this.vistorView.setText("999+");
      } else {
        this.vistorView.setText(String.valueOf(this.headInfo.todayVisitor));
      }
      if (this.headInfo.loginDays > 999L) {
        this.loginDaysView.setText("999+");
      } else {
        this.loginDaysView.setText(String.valueOf(this.headInfo.loginDays));
      }
      if (this.headInfo.registerDays > 9999L)
      {
        this.registerDyasView.setText("9999+");
        return;
      }
      this.registerDyasView.setText(String.valueOf(this.headInfo.registerDays));
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2080571462)
    {
      if (i != 2080571524) {
        return;
      }
      onDetailClick(this.headInfo);
      return;
    }
    if (this.onDetailClickListner != null)
    {
      paramView = getVisitorJumpUrl();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" jump url = ");
        localStringBuilder.append(paramView);
        QLog.i("QZoneMsg", 0, localStringBuilder.toString());
      }
      VipReporterManager.a(9, 2);
      this.onDetailClickListner.onDetailClick(paramView, 2080571462);
    }
  }
  
  public void setHeadInfo(TimeHeaderLayout.HeadInfo paramHeadInfo)
  {
    this.headInfo = paramHeadInfo;
    if (paramHeadInfo != null) {
      ThreadManagerV2.executeOnSubThread(new TimeHeaderLayout.1(this));
    }
  }
  
  public void setOnDetailClickListner(TimeHeaderLayout.OnDetailClickListner paramOnDetailClickListner)
  {
    this.onDetailClickListner = paramOnDetailClickListner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.TimeHeaderLayout
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MagicFaceAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, IEmotionPanelDataCallback<EmotionPanelData>
{
  public static final int CONTENT_HIGHT = 72;
  public static final int IMG_HEIGHT = 56;
  public static final String MAGIC_GRAY_PIC = "_panel_magic_gray";
  private static final int MSG_DOWNLOAD_END = 101;
  private static final int MSG_DOWNLOAD_START = 100;
  private static final int SIZE_BIG_EMOTICON = 63;
  public static final String TAG = "MagicFaceAdapter";
  private MqqHandler mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  List<ProgressBar> proBars = new ArrayList();
  
  public MagicFaceAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
  }
  
  private RelativeLayout getMagicView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "getMagicView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(this.density * 72.0F)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131378202);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(14, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setLayoutParams(localLayoutParams1);
    localRelativeLayout.addView((View)localObject);
    localObject = new TextView(this.mContext);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setId(2131374392);
    ((TextView)localObject).setTextSize(11.0F);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(3, 2131378202);
    localLayoutParams1.topMargin = ((int)(this.density * 5.0F));
    localLayoutParams1.addRule(14, -1);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setId(2131374393);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(8, 2131378202);
    localLayoutParams1.addRule(7, 2131378202);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131366145);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(5, 2131378202);
    localLayoutParams1.addRule(6, 2131378202);
    ProgressBar localProgressBar = new ProgressBar(this.mContext);
    localProgressBar.setVisibility(8);
    localProgressBar.setId(2131366142);
    localProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(2130846461));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams((int)(this.density * 16.0F), (int)(this.density * 16.0F));
    localLayoutParams2.addRule(14, -1);
    localLayoutParams2.topMargin = ((int)(this.density * 20.0F));
    localRelativeLayout.addView(localProgressBar, localLayoutParams2);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    if (AppSetting.d) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private ProgressBar getProgressBarByEp(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage != null)
    {
      if (TextUtils.isEmpty(paramEmoticonPackage.epId)) {
        return null;
      }
      Object localObject = this.proBars;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        Iterator localIterator = this.proBars.iterator();
        while (localIterator.hasNext())
        {
          ProgressBar localProgressBar = (ProgressBar)localIterator.next();
          localObject = localProgressBar.getTag();
          if ((localObject instanceof String)) {
            localObject = (String)localObject;
          } else {
            localObject = null;
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramEmoticonPackage.epId.equals(localObject))) {
            return localProgressBar;
          }
        }
      }
    }
    return null;
  }
  
  private void updateImageView(URLImageView paramURLImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramURLImageView != null) && (paramPicEmoticonInfo != null))
    {
      Object localObject1 = (RelativeLayout.LayoutParams)paramURLImageView.getLayoutParams();
      Object localObject2;
      if ("push".equals(paramPicEmoticonInfo.action))
      {
        ((RelativeLayout.LayoutParams)localObject1).width = ((int)(this.density * 63.0F));
        ((RelativeLayout.LayoutParams)localObject1).height = ((int)(this.density * 63.0F));
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceAdapter", 2, "show push_btn drawable.");
        }
        paramPicEmoticonInfo = this.mContext.getSharedPreferences("mobileQQ", 0);
        localObject1 = this.app.getCurrentAccountUin();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("magic_promotion_is_new_content_");
        ((StringBuilder)localObject2).append((String)localObject1);
        boolean bool = paramPicEmoticonInfo.getBoolean(((StringBuilder)localObject2).toString(), false);
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.mContext.getResources().getDrawable(2130846448);
        if (bool)
        {
          paramPicEmoticonInfo = paramPicEmoticonInfo.getString("magic_promotion_gifUrl", "");
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        }
        else
        {
          paramPicEmoticonInfo = paramPicEmoticonInfo.getString("magic_promotion_imgUrl", "");
        }
        if (!TextUtils.isEmpty(paramPicEmoticonInfo)) {
          try
          {
            paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramPicEmoticonInfo, (URLDrawable.URLDrawableOptions)localObject1));
          }
          catch (IllegalArgumentException paramPicEmoticonInfo)
          {
            if (QLog.isColorLevel()) {
              QLog.w("MagicFaceAdapter", 2, paramPicEmoticonInfo.getMessage());
            }
            paramURLImageView.setImageDrawable(null);
          }
        } else {
          paramURLImageView.setImageDrawable(null);
        }
        if (AppSetting.d) {
          paramURLImageView.setContentDescription(this.mContext.getString(2131699749));
        }
      }
      else
      {
        Emoticon localEmoticon = paramPicEmoticonInfo.emoticon;
        if ((localEmoticon == null) || (TextUtils.isEmpty(localEmoticon.epId))) {
          break label565;
        }
        EmoticonPackage localEmoticonPackage = ((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(localEmoticon.epId);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localEmoticon.epId);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(localEmoticon.eId);
        localObject2 = ((StringBuilder)localObject1).toString();
        if (localEmoticonPackage.valid)
        {
          localObject1 = localObject2;
          if (2 == localEmoticonPackage.status) {}
        }
        else
        {
          localObject1 = localObject2;
          if (!paramPicEmoticonInfo.isDownLoad)
          {
            paramPicEmoticonInfo = new StringBuilder();
            paramPicEmoticonInfo.append((String)localObject2);
            paramPicEmoticonInfo.append("_panel_magic_gray");
            localObject1 = paramPicEmoticonInfo.toString();
          }
        }
        try
        {
          paramPicEmoticonInfo = new URL("emotion_pic", "fromPanel", (String)localObject1);
        }
        catch (MalformedURLException paramPicEmoticonInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MagicFaceAdapter", 2, "updateImageView ,", paramPicEmoticonInfo);
          }
          paramPicEmoticonInfo = null;
        }
        if (paramPicEmoticonInfo != null)
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.mContext.getResources().getDrawable(2130846447);
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.mContext.getResources().getDrawable(2130846453);
          paramPicEmoticonInfo = URLDrawable.getDrawable(paramPicEmoticonInfo, (URLDrawable.URLDrawableOptions)localObject1);
          paramPicEmoticonInfo.setTag(localEmoticon);
          paramPicEmoticonInfo.addHeader("my_uin", this.app.getCurrentAccountUin());
        }
        else
        {
          paramPicEmoticonInfo = null;
        }
        if (paramPicEmoticonInfo != null) {
          paramURLImageView.setImageDrawable(paramPicEmoticonInfo);
        } else {
          paramURLImageView.setVisibility(4);
        }
        paramURLImageView.setBackgroundDrawable(null);
      }
      return;
      label565:
      QLog.e("MagicFaceAdapter", 1, "updateImageView emotion is null or epid is null");
      return;
    }
    QLog.e("MagicFaceAdapter", 1, "updateImageView view or info = null");
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "updateUI");
    }
    if (paramView != null)
    {
      if (paramEmotionPanelData == null) {
        return;
      }
      Object localObject = null;
      if ((paramEmotionPanelData instanceof EmoticonInfo)) {
        localObject = (PicEmoticonInfo)paramEmotionPanelData;
      }
      int i = 1;
      if (localObject == null)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView.setVisibility(0);
      paramView.setTag(localObject);
      paramEmotionPanelData = (URLImageView)paramView.findViewById(2131378202);
      paramEmotionPanelData.setVisibility(0);
      updateImageView(paramEmotionPanelData, (PicEmoticonInfo)localObject);
      paramEmotionPanelData = (TextView)paramView.findViewById(2131374392);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131366145);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131374393);
      paramView = (ProgressBar)paramView.findViewById(2131366142);
      if ("push".equals(((PicEmoticonInfo)localObject).action))
      {
        paramEmotionPanelData.setVisibility(8);
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(8);
        paramView.setVisibility(8);
        return;
      }
      localObject = ((PicEmoticonInfo)localObject).emoticon;
      if ((localObject != null) && (!TextUtils.isEmpty(((Emoticon)localObject).epId)))
      {
        String str = ((Emoticon)localObject).name;
        if (!TextUtils.isEmpty(str))
        {
          paramEmotionPanelData.setVisibility(0);
          if (str.length() > 5)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str.substring(0, 4));
            localStringBuilder.append("...");
            paramEmotionPanelData.setText(localStringBuilder.toString());
          }
          else
          {
            paramEmotionPanelData.setText(str);
          }
          if (AppSetting.d) {
            paramEmotionPanelData.setContentDescription(str);
          }
        }
        else
        {
          paramEmotionPanelData.setVisibility(8);
        }
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(8);
        if (!((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(((Emoticon)localObject).epId).valid)
        {
          localImageView2.setImageResource(2130846462);
          localImageView2.setVisibility(0);
        }
        paramView.setVisibility(8);
        paramView.setTag(((Emoticon)localObject).epId);
        if (!this.proBars.contains(paramView)) {
          this.proBars.add(paramView);
        }
        if (((EmojiManagerServiceProxy)this.app.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(((Emoticon)localObject).epId) < 0.0F) {
          i = 0;
        }
        if (i != 0)
        {
          paramView.setVisibility(0);
          return;
        }
        paramView.setVisibility(8);
        return;
      }
      QLog.e("MagicFaceAdapter", 1, "updateUI emotion is null or epid is null");
    }
  }
  
  public void callbackInMainThread(List<EmotionPanelData> paramList)
  {
    if (paramList != null)
    {
      setData(paramList);
      notifyDataSetChanged();
    }
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (MagicFaceAdapter.MagicFaceViewHolder)paramViewHolder;
    int j = 0;
    int i = j;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append(";view from infalter");
          QLog.d("MagicFaceAdapter", 2, paramViewHolder.toString());
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, null));
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        if (paramInt == 0) {
          paramView.setPadding(0, (int)(this.density * 16.0F), 0, 0);
        } else {
          paramView.setPadding(0, (int)(this.density * 14.0F), 0, 0);
        }
        i = 0;
        for (;;)
        {
          paramViewHolder = paramView;
          if (i >= this.columnNum) {
            break;
          }
          paramViewHolder = getMagicView();
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, -1);
          paramViewHolder.setGravity(17);
          paramViewHolder.setVisibility(8);
          paramViewHolder.setLayoutParams(localLayoutParams);
          paramViewHolder.setFocusable(true);
          paramViewHolder.setFocusableInTouchMode(true);
          paramView.addView(paramViewHolder);
          i += 1;
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("getEmotionView position = ");
        paramViewHolder.append(paramInt);
        paramViewHolder.append(";view from cache");
        QLog.d("MagicFaceAdapter", 2, paramViewHolder.toString());
        paramViewHolder = paramView;
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
      recycleView(this.panelType, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.contentViews = new RelativeLayout[this.columnNum];
      i = 0;
      while (i < this.columnNum)
      {
        paramViewGroup.contentViews[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
      i = j;
    }
    try
    {
      while (i < this.columnNum)
      {
        j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1)
        {
          paramViewGroup.contentViews[i].setTag(null);
          paramViewGroup.contentViews[i].setVisibility(8);
        }
        else
        {
          updateUI(paramViewGroup.contentViews[i], (EmotionPanelData)this.data.get(j));
        }
        i += 1;
      }
    }
    catch (OutOfMemoryError paramView)
    {
      label474:
      break label474;
    }
    QLog.e("MagicFaceAdapter", 1, "updateUI oom");
    return paramViewHolder;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 100)
    {
      if (i == 101)
      {
        ProgressBar localProgressBar = getProgressBarByEp((EmoticonPackage)paramMessage.obj);
        i = paramMessage.arg1;
        if (localProgressBar != null)
        {
          localProgressBar.setVisibility(8);
          if (i == 0) {
            refreshPanelData();
          }
        }
      }
    }
    else
    {
      paramMessage = getProgressBarByEp((EmoticonPackage)paramMessage.obj);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
    }
    return true;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new MagicFaceAdapter.MagicFaceViewHolder();
  }
  
  public void packageDownloadEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "packageDownloadEnd");
    }
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramEmoticonPackage;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void packageDownloadStart(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "packageDownloadStart");
    }
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void refreshPanelData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "refreshPanelData");
    }
    EmotionPanelDataBuilder.getInstance().asyncGetEmotionPanelData(this.app, this.panelType, null, -1, 0, false, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.MagicFaceAdapter
 * JD-Core Version:    0.7.0.1
 */
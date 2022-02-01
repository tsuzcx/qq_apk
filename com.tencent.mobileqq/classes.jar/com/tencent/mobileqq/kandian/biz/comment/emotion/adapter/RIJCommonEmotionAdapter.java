package com.tencent.mobileqq.kandian.biz.comment.emotion.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJCommonEmotionInfo;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJCommonEmotionAdapter
  extends TKDBaseEmotionGridAdapter
{
  private final Drawable a = BaseApplication.getContext().getResources().getDrawable(2097479684);
  
  public RIJCommonEmotionAdapter(RIJCommonEmotionAdapterParams paramRIJCommonEmotionAdapterParams)
  {
    super(paramRIJCommonEmotionAdapterParams.a, paramRIJCommonEmotionAdapterParams.b, paramRIJCommonEmotionAdapterParams.f, paramRIJCommonEmotionAdapterParams.d, paramRIJCommonEmotionAdapterParams.e, paramRIJCommonEmotionAdapterParams.c);
    a(paramRIJCommonEmotionAdapterParams);
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("os", 1);
      localJSONObject.put("emoticons_tab", 1);
    }
    catch (JSONException localJSONException)
    {
      QLog.w("RIJCommonEmotionAdapter", 4, localJSONException.getMessage(), localJSONException);
    }
    PublicAccountReportUtils.a(null, "", "0X800BC61", "0X800BC61", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  protected void a(EmoticonImageView paramEmoticonImageView, EmotionPanelData paramEmotionPanelData)
  {
    paramEmotionPanelData = (RIJCommonEmotionInfo)paramEmotionPanelData;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = this.a;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    paramEmotionPanelData = URLDrawable.getDrawable(paramEmotionPanelData.b, localURLDrawableOptions);
    paramEmotionPanelData.startDownload();
    paramEmoticonImageView.setImageDrawable(paramEmotionPanelData);
  }
  
  public void onAdapterSelected()
  {
    super.onAdapterSelected();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */
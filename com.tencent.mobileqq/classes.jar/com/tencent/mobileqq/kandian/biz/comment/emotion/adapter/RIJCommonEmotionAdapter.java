package com.tencent.mobileqq.kandian.biz.comment.emotion.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJCommonEmotionInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJCommonEmotionAdapter
  extends TKDBaseEmotionGridAdapter
{
  private final Drawable a = BaseApplication.getContext().getResources().getDrawable(2097479680);
  
  public RIJCommonEmotionAdapter(RIJCommonEmotionAdapterParams paramRIJCommonEmotionAdapterParams)
  {
    super(paramRIJCommonEmotionAdapterParams.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanelApp, paramRIJCommonEmotionAdapterParams.jdField_a_of_type_AndroidContentContext, paramRIJCommonEmotionAdapterParams.c, paramRIJCommonEmotionAdapterParams.jdField_a_of_type_Int, paramRIJCommonEmotionAdapterParams.b, paramRIJCommonEmotionAdapterParams.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", localJSONObject.toString(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */
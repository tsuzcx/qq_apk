package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.ILayer;
import com.tencent.mobileqq.surfaceviewaction.ISprite;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.IButtonHandle;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class ReadInJoySkinSlideDownView$3
  implements SceneBuilder.IButtonHandle
{
  ReadInJoySkinSlideDownView$3(ReadInJoySkinSlideDownView paramReadInJoySkinSlideDownView, View.OnClickListener paramOnClickListener1, String paramString1, int paramInt, String paramString2, Context paramContext, View.OnClickListener paramOnClickListener2) {}
  
  public void a(ILayer paramILayer, ISprite paramISprite, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView);
    int k = 0;
    int j = 0;
    localObject = ReadInJoyRefreshManager.b((Context)localObject, 0);
    int i;
    if (paramString.equals("close"))
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView);
      paramILayer = new RIJTransMergeKanDianReport.ReportR5Builder();
      try
      {
        paramILayer.addKandianMode();
        paramILayer.addString("skin_id", this.jdField_a_of_type_JavaLangString);
        paramILayer.addInt("channel_id", this.jdField_a_of_type_Int);
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((RefreshData)localObject).isAD) {
            i = 1;
          }
        }
        paramILayer.addInt("ad_page", i);
      }
      catch (JSONException paramISprite)
      {
        paramISprite.printStackTrace();
      }
      paramISprite = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramString = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJAppSetting.a());
      paramISprite.publicAccountReportClickEvent(localQQAppInterface, "", "0X800969E", "0X800969E", 0, 0, paramString, ((StringBuilder)localObject).toString(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView)), paramILayer.build(), false);
      return;
    }
    if (paramString.equals("open_sound"))
    {
      paramILayer = paramILayer.a(HardCodeUtil.a(2131713012));
      if (paramILayer != null) {
        paramILayer.c(0.0F);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a = new MediaPlayer();
        try
        {
          paramILayer = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a;
          paramISprite = new StringBuilder();
          paramISprite.append(this.jdField_b_of_type_JavaLangString);
          paramISprite.append("/audio.mp3");
          paramILayer.setDataSource(paramISprite.toString());
          this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a.prepare();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a.start();
        }
        catch (Exception paramILayer)
        {
          if (!QLog.isColorLevel()) {
            break label390;
          }
        }
        QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramILayer));
      }
      else
      {
        try
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a.isPlaying()) {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a.start();
          }
        }
        catch (Exception paramILayer)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramILayer));
          }
        }
      }
      label390:
      paramILayer = new RIJTransMergeKanDianReport.ReportR5Builder();
      try
      {
        paramILayer.addKandianMode();
        paramILayer.addString("skin_id", this.jdField_a_of_type_JavaLangString);
        paramILayer.addInt("channel_id", this.jdField_a_of_type_Int);
        i = k;
        if (localObject != null)
        {
          i = k;
          if (((RefreshData)localObject).isAD) {
            i = 1;
          }
        }
        paramILayer.addInt("ad_page", i);
      }
      catch (JSONException paramISprite)
      {
        paramISprite.printStackTrace();
      }
      paramISprite = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramString = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJAppSetting.a());
      paramISprite.publicAccountReportClickEvent(localQQAppInterface, "", "0X800969D", "0X800969D", 0, 0, paramString, ((StringBuilder)localObject).toString(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView)), paramILayer.build(), false);
      return;
    }
    paramILayer = JumpParser.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    if (paramILayer != null)
    {
      paramILayer.a();
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView).onClick(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView);
    }
    else if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
    {
      paramILayer = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramILayer.putExtra("url", paramString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramILayer);
      this.jdField_b_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView);
    }
    ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView, this.jdField_a_of_type_Int, paramString, ((BaseNode)paramISprite).g_());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinSlideDownView.3
 * JD-Core Version:    0.7.0.1
 */
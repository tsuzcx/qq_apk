package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
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
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class ReadInJoySkinGuideView$1$2
  implements SceneBuilder.IButtonHandle
{
  ReadInJoySkinGuideView$1$2(ReadInJoySkinGuideView.1 param1) {}
  
  public void a(ILayer paramILayer, ISprite paramISprite, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (paramString.equals("close"))
    {
      this.a.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.a.this$0);
      paramILayer = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramISprite = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramString = this.a.jdField_b_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(RIJAppSetting.a());
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(ReadInJoySkinGuideView.a(this.a.this$0));
      paramILayer.publicAccountReportClickEvent(paramISprite, "", "0X8008C82", "0X8008C82", 0, 0, paramString, (String)localObject1, ((StringBuilder)localObject2).toString(), "", false);
      return;
    }
    if (paramString.equals("use_skin"))
    {
      this.a.jdField_b_of_type_AndroidViewView$OnClickListener.onClick(this.a.this$0);
      SharedPreUtils.i(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
      paramILayer = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramISprite = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramString = this.a.jdField_b_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(RIJAppSetting.a());
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(ReadInJoySkinGuideView.a(this.a.this$0));
      paramILayer.publicAccountReportClickEvent(paramISprite, "", "0X8008C83", "0X8008C83", 0, 0, paramString, (String)localObject1, ((StringBuilder)localObject2).toString(), "", false);
      return;
    }
    label517:
    StringBuilder localStringBuilder;
    if (paramString.equals("open_sound"))
    {
      paramILayer = paramILayer.a(HardCodeUtil.a(2131712706));
      if (paramILayer != null) {
        paramILayer.c(0.0F);
      }
      if (this.a.this$0.a == null)
      {
        this.a.this$0.a = new MediaPlayer();
        try
        {
          paramILayer = this.a.this$0.a;
          paramISprite = new StringBuilder();
          paramISprite.append(this.a.jdField_a_of_type_JavaLangString);
          paramISprite.append("/audio.mp3");
          paramILayer.setDataSource(paramISprite.toString());
          this.a.this$0.a.prepare();
          this.a.this$0.a.start();
        }
        catch (Exception paramILayer)
        {
          if (!QLog.isColorLevel()) {
            break label517;
          }
        }
        QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(paramILayer));
      }
      else
      {
        try
        {
          if (!this.a.this$0.a.isPlaying()) {
            this.a.this$0.a.start();
          }
        }
        catch (Exception paramILayer)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(paramILayer));
          }
        }
      }
      paramILayer = new RIJTransMergeKanDianReport.ReportR5Builder();
      try
      {
        paramILayer.addKandianMode();
        paramILayer.addString("guide_id", this.a.jdField_b_of_type_JavaLangString);
        paramILayer.addInt("channel_id", this.a.jdField_a_of_type_Int);
      }
      catch (JSONException paramISprite)
      {
        paramISprite.printStackTrace();
      }
      paramISprite = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = this.a.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(RIJAppSetting.a());
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReadInJoySkinGuideView.a(this.a.this$0));
      paramISprite.publicAccountReportClickEvent(paramString, "", "0X8008C81", "0X8008C81", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), paramILayer.build(), false);
      return;
    }
    paramILayer = new RIJTransMergeKanDianReport.ReportR5Builder();
    try
    {
      paramILayer.addFolderStatus().addKandianMode().addTabSource();
      paramILayer.addString("guide_id", this.a.jdField_b_of_type_JavaLangString);
      paramILayer.addString("jump_url", paramString);
      paramILayer.addInt("jump_url_type", ((BaseNode)paramISprite).g_());
      paramILayer.addInt("channel_id", this.a.jdField_a_of_type_Int);
    }
    catch (JSONException paramISprite)
    {
      paramISprite.printStackTrace();
    }
    paramISprite = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramString);
    if (paramISprite != null)
    {
      paramISprite.a();
      this.a.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.a.this$0);
      paramISprite = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = this.a.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(RIJAppSetting.a());
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReadInJoySkinGuideView.a(this.a.this$0));
      paramISprite.publicAccountReportClickEvent(paramString, "", "0X8009819", "0X8009819", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), paramILayer.build(), false);
      return;
    }
    if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
    {
      paramISprite = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramISprite.putExtra("url", paramString);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramISprite);
      this.a.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.a.this$0);
      paramISprite = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = this.a.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(RIJAppSetting.a());
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReadInJoySkinGuideView.a(this.a.this$0));
      paramISprite.publicAccountReportClickEvent(paramString, "", "0X8009819", "0X8009819", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), paramILayer.build(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView.1.2
 * JD-Core Version:    0.7.0.1
 */
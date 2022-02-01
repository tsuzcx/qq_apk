package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
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
    Object localObject;
    if (paramString.equals("close"))
    {
      this.a.c.onClick(this.a.this$0);
      paramILayer = this.a.a;
      paramISprite = this.a.d;
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(RIJAppSetting.b());
      paramString = paramString.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(ReadInJoySkinGuideView.a(this.a.this$0));
      PublicAccountReportUtils.a(paramILayer, "", "0X8008C82", "0X8008C82", 0, 0, paramISprite, paramString, ((StringBuilder)localObject).toString(), "", false);
      return;
    }
    if (paramString.equals("use_skin"))
    {
      this.a.e.onClick(this.a.this$0);
      SharedPreUtils.h(this.a.f, this.a.a.getCurrentAccountUin(), true);
      paramILayer = this.a.a;
      paramISprite = this.a.d;
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(RIJAppSetting.b());
      paramString = paramString.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(ReadInJoySkinGuideView.a(this.a.this$0));
      PublicAccountReportUtils.a(paramILayer, "", "0X8008C83", "0X8008C83", 0, 0, paramISprite, paramString, ((StringBuilder)localObject).toString(), "", false);
      return;
    }
    label481:
    StringBuilder localStringBuilder;
    if (paramString.equals("open_sound"))
    {
      paramILayer = paramILayer.a(HardCodeUtil.a(2131910282));
      if (paramILayer != null) {
        paramILayer.c(0.0F);
      }
      if (this.a.this$0.c == null)
      {
        this.a.this$0.c = new MediaPlayer();
        try
        {
          paramILayer = this.a.this$0.c;
          paramISprite = new StringBuilder();
          paramISprite.append(this.a.b);
          paramISprite.append("/audio.mp3");
          paramILayer.setDataSource(paramISprite.toString());
          this.a.this$0.c.prepare();
          this.a.this$0.c.start();
        }
        catch (Exception paramILayer)
        {
          if (!QLog.isColorLevel()) {
            break label481;
          }
        }
        QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(paramILayer));
      }
      else
      {
        try
        {
          if (!this.a.this$0.c.isPlaying()) {
            this.a.this$0.c.start();
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
        paramILayer.addString("guide_id", this.a.d);
        paramILayer.addInt("channel_id", this.a.g);
      }
      catch (JSONException paramISprite)
      {
        paramISprite.printStackTrace();
      }
      paramISprite = this.a.a;
      paramString = this.a.d;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJAppSetting.b());
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReadInJoySkinGuideView.a(this.a.this$0));
      PublicAccountReportUtils.a(paramISprite, "", "0X8008C81", "0X8008C81", 0, 0, paramString, (String)localObject, localStringBuilder.toString(), paramILayer.build(), false);
      return;
    }
    paramILayer = new RIJTransMergeKanDianReport.ReportR5Builder();
    try
    {
      paramILayer.addFolderStatus().addKandianMode().addTabSource();
      paramILayer.addString("guide_id", this.a.d);
      paramILayer.addString("jump_url", paramString);
      paramILayer.addInt("jump_url_type", ((BaseNode)paramISprite).dq_());
      paramILayer.addInt("channel_id", this.a.g);
    }
    catch (JSONException paramISprite)
    {
      paramISprite.printStackTrace();
    }
    paramISprite = JumpParser.a(this.a.a, this.a.f, paramString);
    if (paramISprite != null)
    {
      paramISprite.a();
      this.a.c.onClick(this.a.this$0);
      paramISprite = this.a.a;
      paramString = this.a.d;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJAppSetting.b());
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReadInJoySkinGuideView.a(this.a.this$0));
      PublicAccountReportUtils.a(paramISprite, "", "0X8009819", "0X8009819", 0, 0, paramString, (String)localObject, localStringBuilder.toString(), paramILayer.build(), false);
      return;
    }
    if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
    {
      paramISprite = new Intent(this.a.f, QQBrowserActivity.class);
      paramISprite.putExtra("url", paramString);
      this.a.f.startActivity(paramISprite);
      this.a.c.onClick(this.a.this$0);
      paramISprite = this.a.a;
      paramString = this.a.d;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJAppSetting.b());
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReadInJoySkinGuideView.a(this.a.this$0));
      PublicAccountReportUtils.a(paramISprite, "", "0X8009819", "0X8009819", 0, 0, paramString, (String)localObject, localStringBuilder.toString(), paramILayer.build(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView.1.2
 * JD-Core Version:    0.7.0.1
 */
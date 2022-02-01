package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class ReadInJoySkinSlideDownView$3
  implements SceneBuilder.IButtonHandle
{
  ReadInJoySkinSlideDownView$3(ReadInJoySkinSlideDownView paramReadInJoySkinSlideDownView, View.OnClickListener paramOnClickListener1, String paramString1, int paramInt, String paramString2, Context paramContext, View.OnClickListener paramOnClickListener2) {}
  
  public void a(ILayer paramILayer, ISprite paramISprite, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = ReadInJoySkinSlideDownView.a(this.g);
    int k = 0;
    int j = 0;
    localObject = ReadInJoyRefreshManager.b((Context)localObject, 0);
    int i;
    if (paramString.equals("close"))
    {
      this.a.onClick(this.g);
      paramILayer = new RIJTransMergeKanDianReport.ReportR5Builder();
      try
      {
        paramILayer.addKandianMode();
        paramILayer.addString("skin_id", this.b);
        paramILayer.addInt("channel_id", this.c);
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
      paramISprite = this.b;
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(RIJAppSetting.b());
      PublicAccountReportUtils.a(localQQAppInterface, "", "0X800969E", "0X800969E", 0, 0, paramISprite, paramString.toString(), String.valueOf(ReadInJoySkinSlideDownView.b(this.g)), paramILayer.build(), false);
      return;
    }
    if (paramString.equals("open_sound"))
    {
      paramILayer = paramILayer.a(HardCodeUtil.a(2131910576));
      if (paramILayer != null) {
        paramILayer.c(0.0F);
      }
      if (this.g.c == null)
      {
        this.g.c = new MediaPlayer();
        try
        {
          paramILayer = this.g.c;
          paramISprite = new StringBuilder();
          paramISprite.append(this.d);
          paramISprite.append("/audio.mp3");
          paramILayer.setDataSource(paramISprite.toString());
          this.g.c.prepare();
          this.g.c.start();
        }
        catch (Exception paramILayer)
        {
          if (!QLog.isColorLevel()) {
            break label374;
          }
        }
        QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramILayer));
      }
      else
      {
        try
        {
          if (!this.g.c.isPlaying()) {
            this.g.c.start();
          }
        }
        catch (Exception paramILayer)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramILayer));
          }
        }
      }
      label374:
      paramILayer = new RIJTransMergeKanDianReport.ReportR5Builder();
      try
      {
        paramILayer.addKandianMode();
        paramILayer.addString("skin_id", this.b);
        paramILayer.addInt("channel_id", this.c);
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
      paramISprite = this.b;
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(RIJAppSetting.b());
      PublicAccountReportUtils.a(localQQAppInterface, "", "0X800969D", "0X800969D", 0, 0, paramISprite, paramString.toString(), String.valueOf(ReadInJoySkinSlideDownView.b(this.g)), paramILayer.build(), false);
      return;
    }
    paramILayer = JumpParser.a(localQQAppInterface, this.e, paramString);
    if (paramILayer != null)
    {
      paramILayer.a();
      ReadInJoySkinSlideDownView.c(this.g).onClick(this.g);
    }
    else if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
    {
      paramILayer = new Intent(this.e, QQBrowserActivity.class);
      paramILayer.putExtra("url", paramString);
      this.e.startActivity(paramILayer);
      this.f.onClick(this.g);
    }
    ReadInJoySkinSlideDownView.a(this.g, this.c, paramString, ((BaseNode)paramISprite).dq_());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinSlideDownView.3
 * JD-Core Version:    0.7.0.1
 */
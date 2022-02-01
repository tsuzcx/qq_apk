package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.base.BaseBlockPart;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class PublishSavePart
  extends BaseBlockPart
  implements View.OnClickListener, SimpleEventReceiver
{
  public static final String a;
  private boolean b = true;
  private ImageView e;
  private TextView f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("FSSavePart");
    a = localStringBuilder.toString();
  }
  
  public static void a(List<String> paramList)
  {
    boolean bool = false;
    if (QCircleHostQzoneHelper.getInt4Uin("qcircle_publish_selected_grid_save", QCircleConfigHelper.a("qqcircle", "qqcircle_save_media_in_device_when_publish", Integer.valueOf(0)).intValue(), LoginData.a().b()) == 1) {
      bool = true;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savePics... mIsNeedSaveGridContent:");
    localStringBuilder.append(bool);
    QLog.d(str, 1, localStringBuilder.toString());
    if ((QCircleConfigHelper.b()) && (bool)) {
      a(paramList, QCircleHostConstants.AppConstants.SDCARD_IMG_SAVE());
    }
  }
  
  public static void a(List<String> paramList, String paramString)
  {
    if (paramList.size() > 0)
    {
      RFThreadManager.execute(new PublishSavePart.1(paramList, paramString), RFThreadManager.Normal);
      return;
    }
    QLog.d(a, 1, "saveMediaToAlbum... No elements in param imageFiles");
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (QCircleConfigHelper.b())
    {
      this.e = ((ImageView)paramView.findViewById(2131441866));
      this.f = ((TextView)paramView.findViewById(2131441867));
      this.e.setOnClickListener(this);
      paramView.findViewById(2131441738).setVisibility(0);
      boolean bool;
      if (QCircleHostQzoneHelper.getInt4Uin("qcircle_publish_selected_grid_save", QCircleConfigHelper.a("qqcircle", "qqcircle_save_media_in_device_when_publish", Integer.valueOf(1)).intValue(), LoginData.a().b()) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.b = bool;
      QLog.d(a, 1, new Object[] { "onInitView... mIsNeedSaveGridContent:", Boolean.valueOf(this.b) });
      if (this.b)
      {
        this.e.setBackgroundDrawable(c().getResources().getDrawable(2130846094));
        this.f.setTextColor(c().getResources().getColor(2131167464));
        return;
      }
      this.e.setBackgroundDrawable(c().getResources().getDrawable(2130846093));
      this.f.setTextColor(c().getResources().getColor(2131167465));
    }
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishSavePart
 * JD-Core Version:    0.7.0.1
 */
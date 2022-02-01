package com.tencent.mobileqq.minigame.manager;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.CommExtInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class GameCloseManager$ChangeAllOnClickListener
  implements View.OnClickListener
{
  private String appId;
  public DialogInterface.OnClickListener closeListener;
  public Dialog dialog;
  public CommExtInfo ext;
  private Activity gameActivity;
  private MiniAppConfig gameConfig;
  private String refer;
  private int versionType;
  private String via;
  
  public GameCloseManager$ChangeAllOnClickListener(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, MiniAppConfig paramMiniAppConfig)
  {
    this.gameActivity = paramActivity;
    this.appId = paramString1;
    this.versionType = paramInt;
    this.refer = paramString2;
    this.via = paramString3;
    this.gameConfig = paramMiniAppConfig;
  }
  
  private COMM.StCommonExt processCommExtInfo()
  {
    COMM.StCommonExt localStCommonExt = null;
    if (this.ext != null)
    {
      localStCommonExt = new COMM.StCommonExt();
      if (this.ext.attachInfo != null) {
        localStCommonExt.attachInfo.set(this.ext.attachInfo);
      }
      if (this.ext.mapInfo != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.ext.mapInfo.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)this.ext.mapInfo.get(str1);
          COMM.Entry localEntry = new COMM.Entry();
          localEntry.key.set(str1);
          localEntry.value.set(str2);
          localArrayList.add(localEntry);
        }
        localStCommonExt.mapInfo.set(localArrayList);
      }
    }
    return localStCommonExt;
  }
  
  public void onClick(View paramView)
  {
    paramView = processCommExtInfo();
    MiniProgramLpReportDC04239.reportAsync(this.gameConfig, "minigame_popup", "refresh", "click", "");
    MiniAppCmdUtil.getInstance().useUserApp(this.appId, this.versionType, 0, this.refer, this.via, paramView, new GameCloseManager.ChangeAllOnClickListener.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.ChangeAllOnClickListener
 * JD-Core Version:    0.7.0.1
 */
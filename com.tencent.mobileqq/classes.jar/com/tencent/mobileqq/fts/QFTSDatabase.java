package com.tencent.mobileqq.fts;

import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;

public class QFTSDatabase
  extends FTSDatabase
{
  protected boolean a()
  {
    if ((Build.VERSION.SDK_INT < 18) && (!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq"))) {
      com.tencent.mobileqq.app.proxy.FTSDBManager.a = false;
    }
    boolean bool = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "FTSDatabaseV2");
    if (!bool) {
      com.tencent.mobileqq.app.proxy.FTSDBManager.a = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.fts.QFTSDatabase
 * JD-Core Version:    0.7.0.1
 */
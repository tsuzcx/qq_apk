package com.tencent.mobileqq.fts.v2;

import android.os.Build.VERSION;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.fts.FTSDatabase;
import mqq.app.MobileQQ;

public class QFTSDatabase
  extends FTSDatabase
{
  protected boolean a()
  {
    if ((Build.VERSION.SDK_INT < 18) && (!SoLoadUtilNew.loadSoByName(MobileQQ.getContext(), "sqlite_qq"))) {
      com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl.ENABLE = false;
    }
    boolean bool = SoLoadUtilNew.loadSoByName(MobileQQ.getContext(), "FTSDatabaseV2");
    if (!bool) {
      com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl.ENABLE = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.QFTSDatabase
 * JD-Core Version:    0.7.0.1
 */
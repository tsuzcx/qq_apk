package com.tencent.mobileqq.selectmember;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;

class TroopAddFrdsInnerFrame$2
  implements IFriendObserver
{
  TroopAddFrdsInnerFrame$2(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onAddFriend %s", new Object[] { paramString }));
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    paramString = this.a.a.obtainMessage(9);
    paramString.obj = localArrayList;
    paramString.sendToTarget();
  }
  
  public void a(boolean paramBoolean, String paramString, ArrayList<cmd0x777.AddFrdInfo> paramArrayList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 109)
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (ArrayList)paramObject[1]);
      return;
    }
    if ((paramInt == 62) && (paramBoolean) && (paramObject != null) && ((paramObject instanceof String))) {
      a((String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.2
 * JD-Core Version:    0.7.0.1
 */
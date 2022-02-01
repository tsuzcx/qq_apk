package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public class ReadInJoyOperationManager
  extends ReadInJoyBaseResManager
{
  protected boolean g = false;
  
  public ReadInJoyOperationManager(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public int a(int paramInt)
  {
    try
    {
      paramInt = this.f.delete(GuideData.class.getSimpleName(), "source=?", new String[] { String.valueOf(paramInt) });
      return paramInt;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyOperationManager", 2, localException, new Object[0]);
      }
    }
    return -1;
  }
  
  public BaseResData a(String paramString)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if ("operation_guide".equals(str1)) {
      paramString = GuideData.class;
    } else {
      paramString = null;
    }
    if (paramString == null) {
      return null;
    }
    String str2 = this.c.getCurrentAccountUin();
    paramString = this.f.query(paramString, paramString.getSimpleName(), true, "uin=? and showTime!=0 and business=?", new String[] { str2, str1 }, null, null, "showTime desc", "1");
    if ((paramString != null) && (paramString.size() > 0)) {
      return (BaseResData)paramString.get(0);
    }
    return null;
  }
  
  public void a()
  {
    if (this.f != null)
    {
      this.f.drop(GuideData.class);
      return;
    }
    QLog.e("ReadInJoyOperationManager", 1, "[clearGuideDataInDatabase] entity manager is null");
  }
  
  public void a(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.isReady = true;
    paramBaseResData.business = paramString;
    this.f.persistOrReplace(paramBaseResData);
  }
  
  public void a(String[] paramArrayOfString) {}
  
  public List<GuideData> b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramString1 = this.c.getCurrentAccountUin();
    return this.f.query(GuideData.class, GuideData.class.getSimpleName(), true, "uin=? and showTime=? and business=? and endTime>? and id=?", new String[] { paramString1, "0", str, String.valueOf(i), paramString2 }, null, null, "seq desc", null);
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return true;
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    return SceneBuilder.a(new File(a(paramString, paramBaseResData.id)));
  }
  
  public void d(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.showTime = ((int)(System.currentTimeMillis() / 1000L));
    paramBaseResData.setStatus(1000);
    this.f.persistOrReplace(paramBaseResData);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoyOperationManager
 * JD-Core Version:    0.7.0.1
 */
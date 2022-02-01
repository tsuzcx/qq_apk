package com.tencent.mobileqq.scribble;

import bbxr;
import beum;
import beuo;
import bevl;
import bevn;
import bezv;
import bhmi;
import bhnv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ScribbleResMgr$4
  implements Runnable
{
  ScribbleResMgr$4(ScribbleResMgr paramScribbleResMgr, ScribbleResMgr.ResInfo paramResInfo) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ScribbleResMgr.b(this.a.resType, this.a.sourceId);
    if (bhmi.a((String)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "res exist, return:" + this.a.sourceId + " " + this.a.resType + " file:" + (String)localObject2 + " url:" + this.a.sourceUrl);
      }
      localObject1 = (bezv)((QQAppInterface)localObject1).getManager(193);
      if (((bezv)localObject1).a()) {
        ((bezv)localObject1).a(this.a.sourceUrl, bhmi.b((String)localObject2));
      }
      ScribbleResMgr.a(this.this$0, this.a, 1);
    }
    do
    {
      return;
      ScribbleResMgr.b(this.this$0, this.a.resType, this.a.sourceId, true);
      localObject2 = new beum();
      ((beum)localObject2).jdField_a_of_type_Beuq = new bbxr(this);
      ((beum)localObject2).jdField_a_of_type_JavaLangString = this.a.sourceUrl;
      ((beum)localObject2).jdField_a_of_type_Int = 0;
      if (this.a.resType == 1) {
        ((beum)localObject2).c = ScribbleResMgr.b(this.a.resType, this.a.sourceId);
      }
      if (this.a.resType == 2) {
        ((beum)localObject2).c = ScribbleResMgr.a(this.a.sourceId);
      }
      ScribbleResMgr.a(this.this$0, ((beum)localObject2).c);
      ((beum)localObject2).b = bhnv.a(bevn.a().a());
      ((QQAppInterface)localObject1).getNetEngine(0).a((bevl)localObject2);
    } while (!QLog.isColorLevel());
    QLog.i("ScribbleResMgrdownloading", 2, "starthttpDownloadscribbleRes, url: " + this.a.sourceUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.4
 * JD-Core Version:    0.7.0.1
 */
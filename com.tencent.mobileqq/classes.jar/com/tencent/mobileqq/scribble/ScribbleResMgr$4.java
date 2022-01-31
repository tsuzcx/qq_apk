package com.tencent.mobileqq.scribble;

import awhb;
import ayrv;
import ayry;
import aysw;
import aysy;
import ayxq;
import bbdj;
import bbev;
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
    if (bbdj.a((String)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "res exist, return:" + this.a.sourceId + " " + this.a.resType + " file:" + (String)localObject2 + " url:" + this.a.sourceUrl);
      }
      localObject1 = (ayxq)((QQAppInterface)localObject1).getManager(193);
      if (((ayxq)localObject1).a()) {
        ((ayxq)localObject1).a(this.a.sourceUrl, bbdj.b((String)localObject2));
      }
      ScribbleResMgr.a(this.this$0, this.a, 1);
    }
    do
    {
      return;
      ScribbleResMgr.b(this.this$0, this.a.resType, this.a.sourceId, true);
      localObject2 = new ayrv();
      ((ayrv)localObject2).jdField_a_of_type_Aysa = new awhb(this);
      ((ayrv)localObject2).jdField_a_of_type_JavaLangString = this.a.sourceUrl;
      ((ayrv)localObject2).jdField_a_of_type_Int = 0;
      if (this.a.resType == 1) {
        ((ayrv)localObject2).jdField_c_of_type_JavaLangString = ScribbleResMgr.b(this.a.resType, this.a.sourceId);
      }
      if (this.a.resType == 2) {
        ((ayrv)localObject2).jdField_c_of_type_JavaLangString = ScribbleResMgr.a(this.a.sourceId);
      }
      ScribbleResMgr.a(this.this$0, ((ayrv)localObject2).jdField_c_of_type_JavaLangString);
      ((ayrv)localObject2).jdField_c_of_type_Int = bbev.a(aysy.a().a());
      ((QQAppInterface)localObject1).getNetEngine(0).a((aysw)localObject2);
    } while (!QLog.isColorLevel());
    QLog.i("ScribbleResMgrdownloading", 2, "starthttpDownloadscribbleRes, url: " + this.a.sourceUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.scribble;

import aygq;
import baub;
import baue;
import bave;
import bavg;
import bbaa;
import bdhb;
import bdin;
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
    if (bdhb.a((String)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "res exist, return:" + this.a.sourceId + " " + this.a.resType + " file:" + (String)localObject2 + " url:" + this.a.sourceUrl);
      }
      localObject1 = (bbaa)((QQAppInterface)localObject1).getManager(193);
      if (((bbaa)localObject1).a()) {
        ((bbaa)localObject1).a(this.a.sourceUrl, bdhb.b((String)localObject2));
      }
      ScribbleResMgr.a(this.this$0, this.a, 1);
    }
    do
    {
      return;
      ScribbleResMgr.b(this.this$0, this.a.resType, this.a.sourceId, true);
      localObject2 = new baub();
      ((baub)localObject2).jdField_a_of_type_Baug = new aygq(this);
      ((baub)localObject2).jdField_a_of_type_JavaLangString = this.a.sourceUrl;
      ((baub)localObject2).jdField_a_of_type_Int = 0;
      if (this.a.resType == 1) {
        ((baub)localObject2).jdField_c_of_type_JavaLangString = ScribbleResMgr.b(this.a.resType, this.a.sourceId);
      }
      if (this.a.resType == 2) {
        ((baub)localObject2).jdField_c_of_type_JavaLangString = ScribbleResMgr.a(this.a.sourceId);
      }
      ScribbleResMgr.a(this.this$0, ((baub)localObject2).jdField_c_of_type_JavaLangString);
      ((baub)localObject2).jdField_c_of_type_Int = bdin.a(bavg.a().a());
      ((QQAppInterface)localObject1).getNetEngine(0).a((bave)localObject2);
    } while (!QLog.isColorLevel());
    QLog.i("ScribbleResMgrdownloading", 2, "starthttpDownloadscribbleRes, url: " + this.a.sourceUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.4
 * JD-Core Version:    0.7.0.1
 */
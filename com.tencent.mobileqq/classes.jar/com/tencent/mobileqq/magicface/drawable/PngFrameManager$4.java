package com.tencent.mobileqq.magicface.drawable;

import adus;
import anzr;
import aobp;
import asce;
import asch;
import asck;
import askf;
import bbwu;
import bbwz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PngFrameManager$4
  implements Runnable
{
  public PngFrameManager$4(asce paramasce, asck paramasck) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func showPngFrame, zip NOT exist, download from Server.");
    }
    Object localObject3 = (askf)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    Object localObject2 = ((askf)localObject3).a(this.a.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.a.jdField_a_of_type_JavaLangString;
      ((EmoticonPackage)localObject1).aio = true;
    }
    ((EmoticonPackage)localObject1).rscType = 1;
    ((askf)localObject3).a((EmoticonPackage)localObject1);
    String str = this.a.jdField_a_of_type_Adus.a.a.eId;
    localObject2 = anzr.f.replace("[eIdSub]", str.substring(0, 2)).replace("[eId]", str);
    localObject1 = anzr.s.replace("[epId]", this.a.jdField_a_of_type_JavaLangString).replace("[eId]", str);
    localObject3 = anzr.j.replace("[eIdSub]", str.substring(0, 2)).replace("[eId]", str).replace("[width]", "200").replace("[height]", "200");
    str = anzr.q.replace("[epId]", this.a.jdField_a_of_type_JavaLangString).replace("[eId]", str);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    localArrayList.add(localObject2);
    localHashMap.put(localObject2, new File((String)localObject1));
    localArrayList.add(localObject3);
    localHashMap.put(localObject3, new File(str));
    localObject2 = new bbwu(localArrayList, localHashMap, "random_magicface_" + this.a.jdField_a_of_type_JavaLangString);
    ((bbwu)localObject2).n = true;
    this.this$0.jdField_a_of_type_Bbwz.a((bbwu)localObject2, new asch(this, (String)localObject1), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.4
 * JD-Core Version:    0.7.0.1
 */
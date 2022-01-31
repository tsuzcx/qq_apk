package dov.com.qq.im.ae.album.logic;

import aimj;
import aimk;
import android.content.Intent;
import azmj;
import bkml;
import bknd;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class AEPhotoListLogicDefault$1
  implements Runnable
{
  public AEPhotoListLogicDefault$1(bknd parambknd, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      PhotoUtils.a(((bkml)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_Aimk.jdField_a_of_type_JavaUtilHashMap, this.this$0.jdField_a_of_type_Aimj.currentQualityType, false);
    }
    for (;;)
    {
      azmj.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      ayyu.b = System.currentTimeMillis();
      return;
      PhotoUtils.a(((bkml)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_Aimj.currentQualityType, this.this$0.jdField_a_of_type_Aimk.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.1
 * JD-Core Version:    0.7.0.1
 */
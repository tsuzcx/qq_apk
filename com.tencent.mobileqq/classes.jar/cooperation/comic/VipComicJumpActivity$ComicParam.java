package cooperation.comic;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

public class VipComicJumpActivity$ComicParam
{
  public int a;
  public long a;
  Intent jdField_a_of_type_AndroidContentIntent = new Intent();
  Bundle jdField_a_of_type_AndroidOsBundle;
  VipComicJumpActivity.ComicInfo jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo = null;
  VipComicJumpActivity.PageOpenTraceInfo jdField_a_of_type_CooperationComicVipComicJumpActivity$PageOpenTraceInfo;
  String jdField_a_of_type_JavaLangString = null;
  HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = "com.qqcomic.activity.VipComicMainTabActivity";
  boolean jdField_b_of_type_Boolean;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  String jdField_e_of_type_JavaLangString = null;
  boolean jdField_e_of_type_Boolean = true;
  String jdField_f_of_type_JavaLangString = null;
  boolean jdField_f_of_type_Boolean = false;
  String jdField_g_of_type_JavaLangString = "";
  boolean jdField_g_of_type_Boolean = false;
  String jdField_h_of_type_JavaLangString = "";
  boolean jdField_h_of_type_Boolean = false;
  String jdField_i_of_type_JavaLangString = "";
  boolean jdField_i_of_type_Boolean = false;
  
  public VipComicJumpActivity$ComicParam()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  boolean a(String paramString)
  {
    return (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) && (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).booleanValue());
  }
  
  public String toString()
  {
    return "ComicParam{clickTime=" + this.jdField_a_of_type_Long + ", startTime=" + this.jdField_b_of_type_Long + ", sourceFrom=" + this.jdField_a_of_type_Int + ", extUrlParam='" + this.jdField_a_of_type_JavaLangString + '\'' + ", jumpConponentName='" + this.jdField_b_of_type_JavaLangString + '\'' + ", jumpurl='" + this.jdField_c_of_type_JavaLangString + '\'' + ", comicInfo=" + this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo + ", jumpMainTab='" + this.jdField_d_of_type_JavaLangString + '\'' + ", jumpSubTab='" + this.jdField_e_of_type_JavaLangString + '\'' + ", leftViewText='" + this.jdField_f_of_type_JavaLangString + '\'' + ", returnDetail=" + this.jdField_a_of_type_Boolean + ", returnToHome=" + this.jdField_b_of_type_Boolean + ", returnHomeFromDetail=" + this.jdField_c_of_type_Boolean + ", isPlayerLocked=" + this.jdField_d_of_type_Boolean + ", needClearTop=" + this.jdField_e_of_type_Boolean + ", isFullscreen=" + this.jdField_f_of_type_Boolean + ", mIntent=" + this.jdField_a_of_type_AndroidContentIntent + ", mNeedLaunchPlugin=" + this.jdField_g_of_type_Boolean + ", mIsTabRedMap=" + this.jdField_a_of_type_JavaUtilHashMap + ", mIsNewFlag=" + this.jdField_h_of_type_Boolean + ", mRedDotMissionIds='" + this.jdField_g_of_type_JavaLangString + '\'' + ", mIsJumpActPage=" + this.jdField_i_of_type_Boolean + ", mJumpActUrl='" + this.jdField_i_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity.ComicParam
 * JD-Core Version:    0.7.0.1
 */
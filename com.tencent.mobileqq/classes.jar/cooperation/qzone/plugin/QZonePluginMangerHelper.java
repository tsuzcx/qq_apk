package cooperation.qzone.plugin;

import amxc;
import amxg;
import amxy;
import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class QZonePluginMangerHelper
{
  public static amxg a;
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new amxy();
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(Context paramContext, QZonePluginMangerHelper.OnQzonePluginClientReadyListner paramOnQzonePluginClientReadyListner)
  {
    if ((jdField_a_of_type_Amxg != null) && (jdField_a_of_type_Amxg.b()))
    {
      if (paramOnQzonePluginClientReadyListner != null) {
        paramOnQzonePluginClientReadyListner.a(jdField_a_of_type_Amxg);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnQzonePluginClientReadyListner);
    amxc.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
  }
  
  private static void b()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      jdField_a_of_type_JavaLangRefWeakReference.clear();
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginMangerHelper
 * JD-Core Version:    0.7.0.1
 */
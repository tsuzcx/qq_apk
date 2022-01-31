package cooperation.qzone.plugin;

import android.content.Context;
import android.content.ServiceConnection;
import aneq;
import aneu;
import anfm;
import java.lang.ref.WeakReference;

public class QZonePluginMangerHelper
{
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new anfm();
  public static aneu a;
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(Context paramContext, QZonePluginMangerHelper.OnQzonePluginClientReadyListner paramOnQzonePluginClientReadyListner)
  {
    if ((jdField_a_of_type_Aneu != null) && (jdField_a_of_type_Aneu.b()))
    {
      if (paramOnQzonePluginClientReadyListner != null) {
        paramOnQzonePluginClientReadyListner.a(jdField_a_of_type_Aneu);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnQzonePluginClientReadyListner);
    aneq.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
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
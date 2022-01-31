import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;

public abstract class ljg
{
  protected static final String[] a;
  public VideoAppInterface a;
  public final String a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "MANAGER_ZIMU", "MANAGER_FILTER", "MANAGER_PENDANT", "MANAGER_FACE", "MANAGER_NODE_REPORTER", "MANAGER_SUPPORT", "MANAGER_REDPACKET", "MANAGER_REDPACKET_Entry", "MANAGER_EFFECT_OPERATE", "MANAGER_ZIMU_LIVE", "MANAGER_Voice_Recog", "MANAGER_Tips", "MANAGER_mutex", "MANAGER_INTERACTIVEVideo" };
  }
  
  protected ljg(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
  }
  
  public static void a(String paramString, Context paramContext, int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < 14) && (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length))
    {
      String str = "Business_" + jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      paramContext = bdiv.b(paramContext).edit();
      paramContext.putBoolean(str, paramBoolean);
      paramContext.commit();
      lek.e(paramString, "setPreload zzzzz  bid=" + paramInt);
      return;
    }
    lek.e(paramString, "setPreload ERROR : bid=" + paramInt);
  }
  
  static boolean a(String paramString, VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 14) && (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length))
    {
      String str = "Business_" + jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      boolean bool = bdiv.b(paramVideoAppInterface.getApplication()).getBoolean(str, false);
      lek.c(paramString, "isPreloaded:" + str + "|" + bool);
      return bool;
    }
    lek.e(paramString, "isPreloaded ERROR : bid=" + paramInt);
    return false;
  }
  
  protected abstract void a();
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected abstract boolean a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ljg
 * JD-Core Version:    0.7.0.1
 */
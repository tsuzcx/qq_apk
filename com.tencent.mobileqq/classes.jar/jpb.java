import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI;
import com.tencent.qphone.base.util.QLog;

class jpb
  implements Runnable
{
  jpb(jpa paramjpa, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = this.jdField_a_of_type_Jpa.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qav_SP", 0);
    if (!((SharedPreferences)localObject1).getBoolean("kick_out_self", false))
    {
      if ((this.jdField_a_of_type_Jpa.a.c != 1) && (this.jdField_a_of_type_Jpa.a.c != 2)) {
        break label173;
      }
      if ((this.jdField_a_of_type_Jpa.a.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Jpa.a.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Jpa.a.b = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Jpa.a.d();
      }
      if (this.jdField_a_of_type_Jpa.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putInt("video_position", this.jdField_a_of_type_Jpa.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.b());
        ((SharedPreferences.Editor)localObject1).commit();
      }
    }
    label173:
    label306:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Jpa.a.c == 3) || (this.jdField_a_of_type_Jpa.a.c == 4))
      {
        if (this.jdField_a_of_type_Jpa.a.jdField_a_of_type_ComTencentAvVideoController == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label300;
          }
        }
        for (localObject1 = localObject2;; localObject1 = ((SessionInfo)localObject1).q)
        {
          if ((localObject1 == null) || (this.jdField_a_of_type_JavaLangString == null) || (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString))) {
            break label306;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "[random room owner] onDestroyUI finish");
          }
          this.jdField_a_of_type_Jpa.a.b = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_Jpa.a.d();
          return;
          localObject1 = this.jdField_a_of_type_Jpa.a.jdField_a_of_type_ComTencentAvVideoController.a();
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpb
 * JD-Core Version:    0.7.0.1
 */
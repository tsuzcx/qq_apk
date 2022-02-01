import android.text.TextUtils;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mkz
  implements GestureDetector.OnGestureListener
{
  private long jdField_a_of_type_Long = -1L;
  private boolean jdField_a_of_type_Boolean;
  
  private mkz(VideoLayerUI paramVideoLayerUI) {}
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    a(false);
    int i = VideoLayerUI.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI);
    if (i == 0) {
      return false;
    }
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a((int)-paramFloat1, 0, i);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, -1000L);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    a(true);
    if (VideoLayerUI.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI)) {}
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    a(false);
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(Math.round(paramFloat1), 0, VideoLayerUI.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI));
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, -1001L);
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 100L)
    {
      bcst.b(null, "CliOper", "", "", "0X8009F62", "0X8009F62", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Long = l;
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramMotionEvent.getX()) != -1)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "error condition print onShowPress");
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    a(false);
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, -1002L);
    if ((VideoLayerUI.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI)) || (!VideoLayerUI.c(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))) {
      return true;
    }
    int j = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramMotionEvent.getX());
    int k;
    Object localObject1;
    int i;
    label270:
    label276:
    Object localObject2;
    if (VideoLayerUI.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))
    {
      if (j == -1) {
        return true;
      }
      paramMotionEvent = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMdt[0];
      String str = paramMotionEvent.b();
      k = paramMotionEvent.h();
      if (TextUtils.isEmpty(str))
      {
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp with empty UIN");
        return true;
      }
      localObject1 = VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a();
      if (((ArrayList)localObject1).size() > VideoLayerUI.f(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))
      {
        i = 1;
        if ((j != VideoLayerUI.f(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) - 2) || (i == 0)) {
          break label276;
        }
        bcst.b(null, "CliOper", "", "", "0X800A069", "0X800A069", 0, 0, "", "", "", "");
        paramMotionEvent = (AVActivity)this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidContentContext;
        if ((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().ac) && (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().ad)) {
          break label270;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        VideoMsgTools.a(paramMotionEvent, String.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().g), bool1, true);
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp jumpTo lists");
        return true;
        i = 0;
        break;
      }
      if (j + 1 > ((ArrayList)localObject1).size() - 1)
      {
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp ArrayOutOfList");
        return true;
      }
      localObject2 = (mld)((ArrayList)localObject1).get(j + 1);
      boolean bool2;
      if (localObject2 != null)
      {
        bool2 = ((mld)localObject2).c();
        if (localObject2 == null) {
          break label760;
        }
        if ((!str.equalsIgnoreCase(String.valueOf(((mld)localObject2).jdField_a_of_type_Long))) || (((mld)localObject2).b() != k)) {
          break label754;
        }
        bool1 = true;
        label363:
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onSingleTapUp, isVideoIn[" + bool2 + "], isSame[" + bool1 + "], uin[" + str + "], currentSelect[" + localObject2 + "], index[" + j + "]");
        }
        label669:
        label688:
        if ((localObject2 != null) && (!bool1))
        {
          bool1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Min.a();
          if ((!bool1) || (!bool2)) {
            break label766;
          }
          bcst.b(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
          str = paramMotionEvent.b();
          i = Integer.valueOf(paramMotionEvent.h()).intValue();
          long l = ((mld)localObject2).jdField_a_of_type_Long;
          k = Integer.valueOf(((mld)localObject2).b()).intValue();
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), str, Integer.valueOf(i), String.valueOf(l), Integer.valueOf(k) });
          QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp mTargetIndex:=" + j + ";Numberlist:=" + ((ArrayList)localObject1).size());
          label634:
          if (!bool2)
          {
            if (!((mld)localObject2).a()) {
              break label846;
            }
            if (((mld)localObject2).a() != this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) {
              break label823;
            }
            bool1 = true;
            if (!bool1) {
              break label829;
            }
            maf.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1051);
            QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "not open camera isSelfUin:=" + bool1);
          }
        }
      }
      for (;;)
      {
        bcst.b(null, "CliOper", "", "", "0X800A068", "0X800A068", 0, 0, "", "", "", "");
        return true;
        bool2 = false;
        break;
        label754:
        bool1 = false;
        break label363;
        label760:
        bool1 = false;
        break label363;
        label766:
        if (!QLog.isColorLevel()) {
          break label634;
        }
        QLog.i(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onSingleTapUp, canSwitchView[" + bool1 + "], isVideoIn[" + bool2 + "]");
        break label634;
        label823:
        bool1 = false;
        break label669;
        label829:
        maf.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1052);
        break label688;
        label846:
        maf.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1053);
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "not attend video talking");
      }
    }
    if (j != -1)
    {
      i = j + 1;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMdt == null) || (i <= 0) || (i >= this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMdt.length)) {
        return true;
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMdt[0];
      paramMotionEvent = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMdt[i];
      if ((localObject2 == null) || (paramMotionEvent == null)) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Min.a())
      {
        bcst.b(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
        localObject1 = ((mdt)localObject2).b();
        j = Integer.valueOf(((mdt)localObject2).h()).intValue();
        localObject2 = paramMotionEvent.b();
        k = Integer.valueOf(paramMotionEvent.h()).intValue();
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), localObject1, Integer.valueOf(j), localObject2, Integer.valueOf(k) });
      }
      if (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) != null) {
        VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(i);
      }
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "condition print onSingleTapUp mTargetIndex:=" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q + ",canSwitchView=" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Min.a());
    }
    for (;;)
    {
      return true;
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "error condition print onSingleTapUp");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mkz
 * JD-Core Version:    0.7.0.1
 */
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

public class mao
  implements GestureDetector.OnGestureListener
{
  private long jdField_a_of_type_Long = -1L;
  private boolean jdField_a_of_type_Boolean;
  
  private mao(VideoLayerUI paramVideoLayerUI) {}
  
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
      awqx.b(null, "CliOper", "", "", "0X8009F62", "0X8009F62", 0, 0, "", "", "", "");
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
      paramMotionEvent = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfLtl[0];
      String str = paramMotionEvent.b();
      k = paramMotionEvent.h();
      if (TextUtils.isEmpty(str))
      {
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp with empty UIN");
        return true;
      }
      localObject1 = VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).b();
      if (((ArrayList)localObject1).size() > VideoLayerUI.f(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))
      {
        i = 1;
        if ((j != VideoLayerUI.f(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) - 2) || (i == 0)) {
          break label276;
        }
        awqx.b(null, "CliOper", "", "", "0X800A069", "0X800A069", 0, 0, "", "", "", "");
        paramMotionEvent = (AVActivity)this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidContentContext;
        if ((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().aa) && (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().ab)) {
          break label270;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        VideoMsgTools.a(paramMotionEvent, String.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().g), bool, true);
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
      localObject2 = (mas)((ArrayList)localObject1).get(j + 1);
      label578:
      label597:
      if (localObject2 != null)
      {
        bool = ((mas)localObject2).c();
        if (localObject2 == null) {
          break label668;
        }
        if ((!str.equalsIgnoreCase(String.valueOf(((mas)localObject2).jdField_a_of_type_Long))) || (((mas)localObject2).b() != k)) {
          break label663;
        }
        i = 1;
        label362:
        if ((localObject2 != null) && (i == 0))
        {
          if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Lyf.a()) && (bool))
          {
            awqx.b(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
            str = paramMotionEvent.b();
            i = Integer.valueOf(paramMotionEvent.h()).intValue();
            long l = ((mas)localObject2).jdField_a_of_type_Long;
            k = Integer.valueOf(((mas)localObject2).b()).intValue();
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), str, Integer.valueOf(i), String.valueOf(l), Integer.valueOf(k) });
            QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp mTargetIndex:=" + j + ";Numberlist:=" + ((ArrayList)localObject1).size());
          }
          if (!bool)
          {
            if (!((mas)localObject2).a()) {
              break label696;
            }
            if (((mas)localObject2).a() != this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) {
              break label673;
            }
            bool = true;
            if (!bool) {
              break label679;
            }
            lqb.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1051);
            QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "not open camera isSelfUin:=" + bool);
          }
        }
      }
      for (;;)
      {
        awqx.b(null, "CliOper", "", "", "0X800A068", "0X800A068", 0, 0, "", "", "", "");
        return true;
        bool = false;
        break;
        label663:
        i = 0;
        break label362;
        label668:
        i = 0;
        break label362;
        label673:
        bool = false;
        break label578;
        label679:
        lqb.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1052);
        break label597;
        label696:
        lqb.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1053);
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "not attend video talking");
      }
    }
    if (j != -1)
    {
      i = j + 1;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfLtl == null) || (i <= 0) || (i >= this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfLtl.length)) {
        return true;
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfLtl[0];
      paramMotionEvent = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfLtl[i];
      if ((localObject2 == null) || (paramMotionEvent == null)) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Lyf.a())
      {
        awqx.b(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
        localObject1 = ((ltl)localObject2).b();
        j = Integer.valueOf(((ltl)localObject2).h()).intValue();
        localObject2 = paramMotionEvent.b();
        k = Integer.valueOf(paramMotionEvent.h()).intValue();
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), localObject1, Integer.valueOf(j), localObject2, Integer.valueOf(k) });
      }
      if (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) != null) {
        VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(i);
      }
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "condition print onSingleTapUp mTargetIndex:=" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q + ",canSwitchView=" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Lyf.a());
    }
    for (;;)
    {
      return true;
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "error condition print onSingleTapUp");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mao
 * JD-Core Version:    0.7.0.1
 */
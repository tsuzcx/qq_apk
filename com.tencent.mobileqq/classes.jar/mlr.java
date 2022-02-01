import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mlr
  extends GestureDetector.SimpleOnGestureListener
{
  public mlr(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean onDoubleTap(MotionEvent arg1)
  {
    int i;
    int j;
    if ((this.a.q == 0) && ((this.a.o == 0) || (this.a.n == 0)) && (2 == this.a.jdField_a_of_type_ArrayOfMep[0].h()) && (!VideoLayerUIBase.b(this.a.jdField_a_of_type_ComTencentAvVideoController.a())))
    {
      i = (int)???.getX();
      j = (int)???.getY();
      float f = this.a.jdField_a_of_type_ArrayOfMep[0].c();
      ??? = this.a;
      ???.p += 1;
      if (this.a.p % 2 == 1)
      {
        f = this.a.jdField_a_of_type_ArrayOfMep[0].b() / f;
        this.a.jdField_a_of_type_ArrayOfMep[0].a(f, i, j);
      }
      for (;;)
      {
        return true;
        f = this.a.jdField_a_of_type_ArrayOfMep[0].a() / f;
        i = this.a.jdField_a_of_type_ArrayOfMep[0].b() / 2;
        j = this.a.jdField_a_of_type_ArrayOfMep[0].c() / 2;
        this.a.jdField_a_of_type_ArrayOfMep[0].a(f, i, j);
        this.a.jdField_a_of_type_ArrayOfMep[0].a(i, j, true);
      }
    }
    if ((this.a.jdField_a_of_type_Mjj != null) && (this.a.jdField_a_of_type_Mjj.a() == 3))
    {
      Object localObject1;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        ??? = this.a.jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder().append("GestureListener-->onDoubleTap in STYLE_MULTI_GRID_SCREEN  Index=").append(this.a.q).append(",visibility:=");
        localObject3 = this.a.jdField_a_of_type_ArrayOfMep;
        if (this.a.q >= 0) {
          break label420;
        }
      }
      label420:
      for (i = 0;; i = this.a.q)
      {
        QLog.d(???, 2, localObject3[i].a());
        if ((VideoLayerUI.c(this.a)) && (this.a.q != -1) && (this.a.q < this.a.jdField_a_of_type_ArrayOfMep.length) && (this.a.jdField_a_of_type_ArrayOfMep[this.a.q].a() != 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0)) {
          break;
        }
        return true;
      }
      if (this.a.q != 0)
      {
        long l = Long.parseLong(this.a.jdField_a_of_type_ArrayOfMep[this.a.q].b());
        j = this.a.jdField_a_of_type_ArrayOfMep[this.a.q].h();
        localObject1 = (lob)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0);
        i = 0;
        if (i < this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size())
        {
          localObject3 = (lob)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(i);
          if ((l != ((lob)localObject3).jdField_a_of_type_Long) || (j != ((lob)localObject3).jdField_a_of_type_Int)) {
            break label759;
          }
          ((lob)localObject1).jdField_a_of_type_Boolean = false;
          ((lob)localObject3).jdField_a_of_type_Boolean = true;
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.set(0, localObject3);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.set(i, localObject1);
        }
      }
      for (;;)
      {
        synchronized (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject3);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(i, localObject1);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().c();
          this.a.a("onDoubleTap", 0, this.a.q);
          bdll.b(null, "CliOper", "", "", "0X8009F61", "0X8009F61", 0, 0, "", "", "", "");
          ((AVActivity)this.a.jdField_a_of_type_AndroidContentContext).a(4, false);
          return true;
        }
        label759:
        i += 1;
        break;
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0) && (!((lob)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Boolean))
        {
          ((lob)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "VideoUiLayer onLayoutModeChange --> displayList  not has big one");
          }
        }
      }
    }
    if ((this.a.jdField_a_of_type_Mjj != null) && (this.a.jdField_a_of_type_Mjj.a() == 4))
    {
      if (!VideoLayerUI.c(this.a)) {
        return true;
      }
      bdll.b(null, "CliOper", "", "", "0X8009F60", "0X8009F60", 0, 0, "", "", "", "");
      ((AVActivity)this.a.jdField_a_of_type_AndroidContentContext).a(3, false);
    }
    return super.onDoubleTap(???);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return false;
    }
    if (this.a.jdField_a_of_type_Long > paramMotionEvent2.getDownTime()) {}
    for (boolean bool3 = true; bool3; bool3 = false)
    {
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onFling, lastHandledEventTime[" + this.a.jdField_a_of_type_Long + "], e1[" + paramMotionEvent1 + "], e2[" + paramMotionEvent2 + "]");
      return false;
    }
    AVActivity localAVActivity = this.a.a();
    if ((localAVActivity == null) || (localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.a() == null) || (localAVActivity.jdField_a_of_type_Mng == null)) {
      return false;
    }
    boolean bool8 = localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
    int i;
    int j;
    label209:
    boolean bool1;
    int k;
    label252:
    long l;
    label270:
    label281:
    label309:
    float f1;
    float f2;
    if (!localAVActivity.jdField_a_of_type_Mng.a())
    {
      i = 1;
      lff locallff = localAVActivity.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallff.jdField_d_of_type_Int != 4) {
        break label613;
      }
      j = 1;
      bool1 = localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoMeetingCtrlUI;
      if ((!this.a.jdField_a_of_type_ArrayOfMep[0].b) && (!this.a.jdField_a_of_type_ArrayOfMep[1].b)) {
        break label619;
      }
      k = 1;
      if ((j == 0) || (!bool1) || (k == 0)) {
        break label625;
      }
      j = 1;
      if (locallff.d()) {
        break label631;
      }
      k = 1;
      if ((localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().b(2)) || (j != 0) || (k == 0)) {
        break label637;
      }
      j = 1;
      l = AudioHelper.b();
      f1 = Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX());
      f2 = Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY());
      if (f1 >= f2) {
        break label655;
      }
      if (paramMotionEvent1.getY() - paramMotionEvent2.getY() < this.a.m) {
        break label643;
      }
      bool1 = true;
      label374:
      if (paramMotionEvent2.getY() - paramMotionEvent1.getY() < this.a.m) {
        break label649;
      }
    }
    boolean bool5;
    boolean bool4;
    label643:
    label649:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool6 = false;
      boolean bool7 = false;
      bool5 = bool1;
      bool4 = bool2;
      bool2 = bool6;
      bool1 = bool7;
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onFling, e1[" + paramMotionEvent1 + "], e2[" + paramMotionEvent2 + "], velocityX[" + paramFloat1 + "], velocityY[" + paramFloat2 + "], xOffset[" + f1 + "], yOffset[" + f2 + "], up[" + bool5 + "], down[" + bool4 + "], left[" + bool1 + "], right[" + bool2 + "], handle[" + bool3 + "], lastHandledEventTime[" + this.a.jdField_a_of_type_Long + "], seq[" + l + "]");
      if ((bool8) || ((!bool5) && (!bool4))) {
        break label724;
      }
      return false;
      i = 0;
      break;
      label613:
      j = 0;
      break label209;
      label619:
      k = 0;
      break label252;
      label625:
      j = 0;
      break label270;
      label631:
      k = 0;
      break label281;
      label637:
      j = 0;
      break label309;
      bool1 = false;
      break label374;
    }
    label655:
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() >= this.a.m)
    {
      bool1 = true;
      label679:
      if (paramMotionEvent2.getX() - paramMotionEvent1.getX() < this.a.m) {
        break label718;
      }
    }
    label718:
    for (bool2 = true;; bool2 = false)
    {
      bool4 = false;
      bool5 = false;
      break;
      bool1 = false;
      break label679;
    }
    label724:
    if ((bool5) && (i != 0))
    {
      if ((localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().b(0)) && (localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l)))
      {
        mrx.a(true);
        localAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l, localAVActivity, 0, 0);
        localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(l, -1);
        return true;
      }
    }
    else if ((bool4) && (i != 0))
    {
      if (localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().b(2))
      {
        mrx.a(false);
        localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(l, 0, true);
        return true;
      }
    }
    else
    {
      if ((!bool2) || (j == 0)) {
        break label869;
      }
      localAVActivity.jdField_a_of_type_Mng.c(1);
      lkd.a("0X800A8D2");
    }
    for (;;)
    {
      return false;
      label869:
      if ((bool1) && (j != 0))
      {
        localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(l, 0, false);
        localAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l, localAVActivity, 0, 1);
        localAVActivity.jdField_a_of_type_Mng.a(2);
        if (!bool8) {
          localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.P();
        }
        lkd.a("0X800A8D1");
      }
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {
      bool1 = false;
    }
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                boolean bool3;
                do
                {
                  do
                  {
                    return bool1;
                    try
                    {
                      l = AudioHelper.b();
                      bool1 = this.a.i();
                      bool3 = this.a.h();
                      if (QLog.isColorLevel()) {
                        QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onSingleTapConfirmed, mTargetIndex[" + this.a.q + "], isDoubleScreen[" + bool1 + "], canMove[" + bool3 + "], seq[" + l + "]");
                      }
                      if ((!VideoLayerUI.b(this.a)) && (this.a.q > 0) && (!bool1)) {
                        break;
                      }
                      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
                      return true;
                    }
                    catch (Exception paramMotionEvent)
                    {
                      bool1 = bool2;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.e(this.a.jdField_a_of_type_JavaLangString, 2, "onSingleTapConfirmed --> Exception = " + paramMotionEvent);
                  return true;
                  if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) {
                    break;
                  }
                  bool1 = bool2;
                } while (!this.a.jdField_a_of_type_Mjj.a());
                this.a.a(0, this.a.q);
                return true;
                if (!bool3) {
                  break;
                }
                bool1 = bool2;
              } while (this.a.jdField_a_of_type_ArrayOfMep == null);
              bool1 = bool2;
            } while (this.a.q <= 0);
            bool1 = bool2;
          } while (this.a.q >= this.a.jdField_a_of_type_ArrayOfMep.length);
          if (!this.a.jdField_a_of_type_Mjj.a()) {
            break;
          }
          localObject = this.a.jdField_a_of_type_ArrayOfMep[0];
          paramMotionEvent = this.a.jdField_a_of_type_ArrayOfMep[this.a.q];
          bool1 = bool2;
        } while (localObject == null);
        bool1 = bool2;
      } while (paramMotionEvent == null);
      String str = ((mep)localObject).b();
      int i = Integer.valueOf(((mep)localObject).h()).intValue();
      Object localObject = paramMotionEvent.b();
      int j = Integer.valueOf(paramMotionEvent.h()).intValue();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), str, Integer.valueOf(i), localObject, Integer.valueOf(j) });
      return true;
      bool1 = bool2;
    } while (this.a.jdField_a_of_type_Mjj.a() != 3);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
    return true;
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlr
 * JD-Core Version:    0.7.0.1
 */
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.TraeHelper.TraeHelperListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class khi
  implements Runnable
{
  khi(khh paramkhh) {}
  
  public void run()
  {
    try
    {
      if ((this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) || ((this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.a().G) && (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) && (NetworkUtil.a(this.a.jdField_a_of_type_AndroidContentContext))) || (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.m()) || (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.l())) {
        break label740;
      }
      if (!this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_c_of_type_Boolean) {
        break label367;
      }
    }
    catch (Exception localException)
    {
      label269:
      label448:
      label726:
      label737:
      label740:
      label745:
      for (;;)
      {
        Object localObject1;
        TipsManager localTipsManager;
        int i;
        label367:
        if (QLog.isColorLevel())
        {
          QLog.d(this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_JavaLangString, 2, "switchButton_handFree exception!!");
          continue;
          Object localObject2;
          if ("DEVICE_EARPHONE".equals(this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.a().o))
          {
            localObject2 = this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.g;
            this.a.jdField_a_of_type_AndroidWidgetButton.setText("听筒");
          }
          else if ("DEVICE_SPEAKERPHONE".equals(this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.a().o))
          {
            localObject2 = this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.h;
            this.a.jdField_a_of_type_AndroidWidgetButton.setText("扬声器");
          }
          else
          {
            localObject2 = this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.h;
            this.a.jdField_a_of_type_AndroidWidgetButton.setText("扬声器");
            continue;
            if (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_d_of_type_MqqUtilWeakReference != null)
            {
              localObject2 = (TipsManager)this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_d_of_type_MqqUtilWeakReference.get();
              if ((localObject2 != null) && (((TipsManager)localObject2).jdField_b_of_type_Int == 1005)) {
                ((TipsManager)localObject2).a();
              }
            }
            if (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_b_of_type_Int == 1) {
              if (i != 0) {
                localObject2 = this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
              }
            }
            for (;;)
            {
              this.a.jdField_a_of_type_AndroidWidgetButton.setText("扬声器");
              break;
              localObject2 = this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              continue;
              if (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_b_of_type_Int == 2)
              {
                if (i != 0)
                {
                  localObject2 = this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
                  continue;
                }
                localObject2 = this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
                continue;
                i = 2131494060;
                break label269;
              }
              localObject2 = null;
            }
            continue;
            i = 1;
          }
        }
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_b_of_type_Boolean) && (TraeHelper.c()))
    {
      if ("DEVICE_BLUETOOTHHEADSET".equals(this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.a().o))
      {
        localObject1 = this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText("蓝牙");
        if (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_d_of_type_MqqUtilWeakReference == null) {
          break label737;
        }
        localTipsManager = (TipsManager)this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_d_of_type_MqqUtilWeakReference.get();
        if ((localTipsManager == null) || (localTipsManager.jdField_b_of_type_Int != 1005)) {
          break label745;
        }
        localTipsManager.a();
        break label745;
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject1, null, null);
        localObject1 = this.a.jdField_a_of_type_AndroidWidgetButton.getResources();
        if (i == 0) {
          break label726;
        }
        i = 2131494068;
        localObject1 = ((Resources)localObject1).getColorStateList(i);
        if (localObject1 != null) {
          this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor((ColorStateList)localObject1);
        }
        if ((this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_c_of_type_MqqUtilWeakReference != null) && (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_c_of_type_MqqUtilWeakReference.get() != null)) {
          ((TraeHelper.TraeHelperListener)this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_c_of_type_MqqUtilWeakReference.get()).a(this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.a().N, this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_b_of_type_Int);
        }
        return;
        i = 0;
        break;
        if (!"DEVICE_WIREDHEADSET".equals(this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentAvVideoController.a().o)) {
          break label448;
        }
        localObject1 = this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.f;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText("耳机");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khi
 * JD-Core Version:    0.7.0.1
 */
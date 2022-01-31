import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.ui.funchat.magicface.MagicfaceViewForAV;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mmz
  implements lhk<FaceItem>
{
  protected RelativeLayout a;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  FaceItem jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem;
  protected MagicfaceViewForAV a;
  WeakReference<ViewGroup> jdField_a_of_type_JavaLangRefWeakReference;
  private lhr jdField_a_of_type_Lhr;
  boolean jdField_a_of_type_Boolean;
  
  public mmz(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Lhr == null) {
      this.jdField_a_of_type_Lhr = ((lhr)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
    }
  }
  
  private void a(long paramLong, ViewGroup paramViewGroup, boolean paramBoolean, FaceItem paramFaceItem, int paramInt)
  {
    if (paramFaceItem.isSameType("face")) {
      b(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_Lhr.a(paramLong, paramFaceItem, paramFaceItem.getId(), paramBoolean, this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV);
      return;
      if ((paramFaceItem.isSameType("pendant")) || (paramFaceItem.isSameType("creativecop"))) {
        a(paramViewGroup);
      } else if (paramFaceItem.isSameType("voicesticker")) {
        b(paramViewGroup);
      }
    }
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    Object localObject = new StringBuilder().append("realyShowView : ");
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    for (boolean bool = true;; bool = false)
    {
      lcg.e("MagicfaceViewProxy", bool);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        localObject = View.inflate(BaseApplicationImpl.getContext(), 2131559537, null);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131369718));
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV = ((MagicfaceViewForAV)((View)localObject).findViewById(2131369716));
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV.setZOrderMediaOverlay(true);
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV.getHolder().setFormat(-2);
        localObject = paramViewGroup.findViewById(2131372534);
        int i = -1;
        if (localObject != null) {
          i = paramViewGroup.indexOfChild((View)localObject);
        }
        paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, i);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
  }
  
  public void a(long paramLong, ViewGroup paramViewGroup, mck parammck)
  {
    boolean bool2 = false;
    Object localObject = new StringBuilder().append("showView, requestPlayMagicFace[").append(parammck).append("], mRootView[");
    if (paramViewGroup != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.w("MagicfaceViewProxy", 1, bool1 + "], mItem[" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem + "], seq[" + paramLong + "]");
      if (paramViewGroup != null) {
        break;
      }
      return;
    }
    a();
    this.jdField_a_of_type_Lhr.a(paramLong, this);
    localObject = (FaceItem)this.jdField_a_of_type_Lhr.a(parammck.c);
    bool1 = bool2;
    if (localObject != null)
    {
      liz localliz = (liz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5);
      bool1 = localliz.a(3, "normal");
      bool2 = localliz.a(3, "interact");
      if ((bool1) && ((bool2) || (!((FaceItem)localObject).isInteract()))) {
        break label253;
      }
      bool1 = true;
      if (bool1) {
        break label300;
      }
      if (!((FaceItem)localObject).isUsable()) {
        break label259;
      }
      a(paramLong, paramViewGroup, parammck.jdField_a_of_type_Boolean, (FaceItem)localObject, parammck.jdField_a_of_type_Int);
    }
    label259:
    label300:
    for (;;)
    {
      QLog.w("MagicfaceViewProxy", 1, "showView, dimmed[" + bool1 + "], item[" + localObject + "]");
      return;
      label253:
      bool1 = false;
      break;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramViewGroup);
      this.jdField_a_of_type_Boolean = parammck.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem = ((FaceItem)localObject);
      this.jdField_a_of_type_Lhr.a(parammck.a(), (lhl)localObject);
    }
  }
  
  public void a(long paramLong, FaceItem paramFaceItem) {}
  
  public void a(long paramLong, FaceItem paramFaceItem, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramFaceItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem.getId().equalsIgnoreCase(paramFaceItem.getId())))
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localViewGroup != null)
      {
        QLog.w("MagicfaceViewProxy", 1, "onDownloadFinish, prepareShow, seq[" + paramLong + "], FaceItem[" + paramFaceItem + "]");
        a(paramLong, localViewGroup, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem, 6);
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("realyHideView : ");
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    for (boolean bool = true;; bool = false)
    {
      lcg.c("MagicfaceViewProxy", bool);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV = null;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      }
      return;
    }
  }
  
  public void a(ViewGroup paramViewGroup, String paramString, boolean paramBoolean)
  {
    if (paramViewGroup == null) {}
    while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)) {
      return;
    }
    a();
    this.jdField_a_of_type_Lhr.b(-1048L, this);
    this.jdField_a_of_type_Lhr.a(0, paramString, paramBoolean);
    a(paramViewGroup);
  }
  
  public void a(FaceItem paramFaceItem, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmz
 * JD-Core Version:    0.7.0.1
 */
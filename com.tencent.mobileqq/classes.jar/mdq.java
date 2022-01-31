import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class mdq
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new mdr(this);
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  ArrayList<mdt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private mdu jdField_a_of_type_Mdu;
  private boolean jdField_a_of_type_Boolean;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new mds(this);
  private boolean jdField_b_of_type_Boolean;
  
  @TargetApi(9)
  public mdq(Context paramContext, VideoAppInterface paramVideoAppInterface, PinnedDividerListView paramPinnedDividerListView, long paramLong, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = paramPinnedDividerListView;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "MVMembersContolUI-->can not get videoControl");
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    this.jdField_a_of_type_Mdu = new mdu(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Mdu);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  private int a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mdt)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void b(ArrayList<ldw> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource");
    }
    if (paramArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource-->friends list is null");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        ldw localldw = (ldw)paramArrayList.get(i);
        mdt localmdt = new mdt(this, null);
        localmdt.jdField_a_of_type_Long = localldw.jdField_a_of_type_Long;
        localmdt.jdField_a_of_type_Boolean = localldw.jdField_a_of_type_Boolean;
        localmdt.jdField_a_of_type_Int = localldw.c;
        localmdt.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = localldw.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        localmdt.c = localldw.e;
        localmdt.d = localldw.f;
        localmdt.e = localldw.h;
        this.jdField_a_of_type_JavaUtilArrayList.add(localmdt);
        i += 1;
      }
    }
  }
  
  public void a()
  {
    boolean bool2 = false;
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
      int j = i;
      for (;;)
      {
        boolean bool1 = bool2;
        if (j < k)
        {
          bool1 = bool2;
          if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            mdt localmdt = (mdt)this.jdField_a_of_type_JavaUtilArrayList.get(j);
            if ((localmdt == null) || (localmdt.jdField_b_of_type_Boolean)) {
              break label143;
            }
            bool1 = true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("GAudioMemberListCtrl", 2, "refreshHeadbitmap-->minIndex=" + i + ",maxIndex=" + k + ",needRefresh=" + bool1);
        }
        if (bool1) {
          this.jdField_a_of_type_Mdu.notifyDataSetChanged();
        }
        return;
        label143:
        j += 1;
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = a(paramLong);
    if (paramInt2 == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",isMicOff=" + paramBoolean);
      }
    }
    mdt localmdt;
    Object localObject;
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
                int i;
                do
                {
                  return;
                  localmdt = (mdt)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
                  localmdt.c = paramBoolean;
                  localmdt.jdField_a_of_type_Int = paramInt1;
                  paramInt1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
                  i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
                } while ((paramInt2 < paramInt1) || (paramInt2 > i));
                paramInt1 = paramInt2 + 1 - paramInt1;
              } while (paramInt1 > this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount());
              localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(paramInt1);
              if (localObject != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view == null , index = " + paramInt2);
            return;
            if (((View)localObject).getTag() != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + paramInt2 + ",uin=" + paramLong + ",isMicOff=" + paramBoolean);
          return;
          localObject = (mdv)((View)localObject).getTag();
        } while (localObject == null);
        if (localmdt.c)
        {
          ((mdv)localObject).c.setVisibility(8);
          if (((mdv)localObject).jdField_a_of_type_AndroidViewView != null) {
            ((mdv)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
        if (!localmdt.c) {
          break;
        }
      } while ((((mdv)localObject).jdField_a_of_type_Int != -1) && (((mdv)localObject).jdField_a_of_type_Int != 0));
      a(((mdv)localObject).jdField_b_of_type_AndroidWidgetImageView, localmdt.c);
      ((mdv)localObject).jdField_a_of_type_Int = 1;
      return;
    } while ((((mdv)localObject).jdField_a_of_type_Int != -1) && (((mdv)localObject).jdField_a_of_type_Int != 1));
    a(((mdv)localObject).jdField_b_of_type_AndroidWidgetImageView, localmdt.c);
    ((mdv)localObject).jdField_a_of_type_Int = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",bSpeak=" + paramBoolean);
      }
    }
    Object localObject;
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
              int j;
              do
              {
                do
                {
                  return;
                  localObject = (mdt)this.jdField_a_of_type_JavaUtilArrayList.get(i);
                  ((mdt)localObject).jdField_a_of_type_Boolean = paramBoolean;
                  if (((mdt)localObject).c)
                  {
                    ((mdt)localObject).jdField_a_of_type_Boolean = false;
                    paramBoolean = false;
                  }
                  j = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
                  int k = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
                  if ((i >= j) && (i <= k)) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view is invisible uin =" + paramLong + " , index = " + i);
                return;
                j = i + 1 - j;
              } while (j > this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount());
              localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(j);
              if (localObject != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view == null , index = " + i);
            return;
            if (((View)localObject).getTag() != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",isSpeak=" + paramBoolean);
          return;
          localObject = (mdv)((View)localObject).getTag();
        } while (localObject == null);
        if ((!paramBoolean) || (!((mdv)localObject).jdField_b_of_type_Boolean)) {
          break;
        }
        ((mdv)localObject).c.setVisibility(0);
      } while (((mdv)localObject).jdField_a_of_type_AndroidViewView == null);
      ((mdv)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      ((mdv)localObject).c.setVisibility(8);
    } while (((mdv)localObject).jdField_a_of_type_AndroidViewView == null);
    ((mdv)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean) {}
      for (i = 2130841470;; i = 2130841469)
      {
        paramImageView.setImageResource(i);
        paramImageView.setContentDescription(ajyc.a(2131705149));
        return;
      }
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 2130841472;; i = 2130841471)
    {
      paramImageView.setImageResource(i);
      paramImageView.setContentDescription(ajyc.a(2131705151));
      return;
    }
  }
  
  public void a(ArrayList<ldw> paramArrayList)
  {
    if (paramArrayList != null)
    {
      b(paramArrayList);
      this.jdField_a_of_type_Mdu.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(i).setTag(null);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = null;
    this.jdField_a_of_type_Mdu = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "onSetMicBySelf uin=" + paramLong + ",isMicOffBySelf=" + paramBoolean);
      }
      return;
    }
    ((mdt)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdq
 * JD-Core Version:    0.7.0.1
 */
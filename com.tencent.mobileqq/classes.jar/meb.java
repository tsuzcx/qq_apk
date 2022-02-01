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

public class meb
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new mec(this);
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  ArrayList<mee> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private mef jdField_a_of_type_Mef;
  private boolean jdField_a_of_type_Boolean;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new med(this);
  private boolean jdField_b_of_type_Boolean;
  
  @TargetApi(9)
  public meb(Context paramContext, VideoAppInterface paramVideoAppInterface, PinnedDividerListView paramPinnedDividerListView, long paramLong, int paramInt, boolean paramBoolean)
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
    this.jdField_a_of_type_Mef = new mef(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Mef);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  private int a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mee)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void b(ArrayList<lcv> paramArrayList)
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
        lcv locallcv = (lcv)paramArrayList.get(i);
        mee localmee = new mee(this, null);
        localmee.jdField_a_of_type_Long = locallcv.jdField_a_of_type_Long;
        localmee.jdField_a_of_type_Boolean = locallcv.jdField_a_of_type_Boolean;
        localmee.jdField_a_of_type_Int = locallcv.d;
        localmee.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = locallcv.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        localmee.c = locallcv.e;
        localmee.d = locallcv.f;
        localmee.e = locallcv.h;
        this.jdField_a_of_type_JavaUtilArrayList.add(localmee);
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
            mee localmee = (mee)this.jdField_a_of_type_JavaUtilArrayList.get(j);
            if ((localmee == null) || (localmee.jdField_b_of_type_Boolean)) {
              break label143;
            }
            bool1 = true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("GAudioMemberListCtrl", 2, "refreshHeadbitmap-->minIndex=" + i + ",maxIndex=" + k + ",needRefresh=" + bool1);
        }
        if (bool1) {
          this.jdField_a_of_type_Mef.notifyDataSetChanged();
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
    mee localmee;
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
                  localmee = (mee)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
                  localmee.c = paramBoolean;
                  localmee.jdField_a_of_type_Int = paramInt1;
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
          localObject = (meg)((View)localObject).getTag();
        } while (localObject == null);
        if (localmee.c)
        {
          ((meg)localObject).c.setVisibility(8);
          if (((meg)localObject).jdField_a_of_type_AndroidViewView != null) {
            ((meg)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
        if (!localmee.c) {
          break;
        }
      } while ((((meg)localObject).jdField_a_of_type_Int != -1) && (((meg)localObject).jdField_a_of_type_Int != 0));
      a(((meg)localObject).jdField_b_of_type_AndroidWidgetImageView, localmee.c);
      ((meg)localObject).jdField_a_of_type_Int = 1;
      return;
    } while ((((meg)localObject).jdField_a_of_type_Int != -1) && (((meg)localObject).jdField_a_of_type_Int != 1));
    a(((meg)localObject).jdField_b_of_type_AndroidWidgetImageView, localmee.c);
    ((meg)localObject).jdField_a_of_type_Int = 0;
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
                  localObject = (mee)this.jdField_a_of_type_JavaUtilArrayList.get(i);
                  ((mee)localObject).jdField_a_of_type_Boolean = paramBoolean;
                  if (((mee)localObject).c)
                  {
                    ((mee)localObject).jdField_a_of_type_Boolean = false;
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
          localObject = (meg)((View)localObject).getTag();
        } while (localObject == null);
        if ((!paramBoolean) || (!((meg)localObject).jdField_b_of_type_Boolean)) {
          break;
        }
        ((meg)localObject).c.setVisibility(0);
      } while (((meg)localObject).jdField_a_of_type_AndroidViewView == null);
      ((meg)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      ((meg)localObject).c.setVisibility(8);
    } while (((meg)localObject).jdField_a_of_type_AndroidViewView == null);
    ((meg)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean) {}
      for (i = 2130841945;; i = 2130841944)
      {
        paramImageView.setImageResource(i);
        paramImageView.setContentDescription(anzj.a(2131704047));
        return;
      }
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 2130841947;; i = 2130841946)
    {
      paramImageView.setImageResource(i);
      paramImageView.setContentDescription(anzj.a(2131704049));
      return;
    }
  }
  
  public void a(ArrayList<lcv> paramArrayList)
  {
    if (paramArrayList != null)
    {
      b(paramArrayList);
      this.jdField_a_of_type_Mef.notifyDataSetChanged();
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
    this.jdField_a_of_type_Mef = null;
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
    ((mee)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     meb
 * JD-Core Version:    0.7.0.1
 */
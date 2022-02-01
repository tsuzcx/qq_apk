package com.tencent.mobileqq.multiaio.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.miniaio.MiniPie;
import com.tencent.mobileqq.activity.miniaio.MiniPieFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.multiaio.view.MultiAioCaller;
import com.tencent.mobileqq.multiaio.view.MultiAioContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiAioContext
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MultiAIOManager jdField_a_of_type_ComTencentMobileqqMultiaioModelMultiAIOManager;
  private MultiAioCaller jdField_a_of_type_ComTencentMobileqqMultiaioViewMultiAioCaller;
  private MultiAioContainer jdField_a_of_type_ComTencentMobileqqMultiaioViewMultiAioContainer;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<MiniPie> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private volatile List<RecentBaseData> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int;
  private volatile Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  
  public MultiAioContext(MultiAIOManager paramMultiAIOManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioModelMultiAIOManager = paramMultiAIOManager;
  }
  
  public static MultiAioContext a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create() called with: app = [");
      ((StringBuilder)localObject).append(paramAppInterface);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAioContext", 2, ((StringBuilder)localObject).toString());
    }
    paramAppInterface = (MultiAIOManager)paramAppInterface.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER);
    Object localObject = new MultiAioContext(paramAppInterface);
    ((MultiAioContext)localObject).c(paramAppInterface.a((MultiAioContext)localObject));
    return localObject;
  }
  
  private void a(List<RecentBaseData> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRecentUserList() called with: recentUserList = [");
      localStringBuilder.append(paramList);
      localStringBuilder.append("]");
      QLog.d("MultiAioContext", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public View a(int paramInt)
  {
    View localView1;
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      localView1 = null;
    } else {
      localView1 = (View)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    Object localObject;
    if (localView1 != null)
    {
      localObject = localView1.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(localView1);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCacheViewFor() called with: position = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], v = ");
      ((StringBuilder)localObject).append(localView1);
      QLog.d("MultiAioContext", 2, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView2 = (View)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCacheViewFor() cached v = [");
        localStringBuilder.append(localView2);
        localStringBuilder.append("]");
        QLog.d("MultiAioContext", 2, localStringBuilder.toString());
      }
    }
    return localView1;
  }
  
  public MiniPie a(MultiAIOItemFragment paramMultiAIOItemFragment)
  {
    int i = paramMultiAIOItemFragment.a();
    MiniPie localMiniPie1;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
      localMiniPie1 = (MiniPie)this.jdField_a_of_type_JavaUtilList.get(i);
    } else {
      localMiniPie1 = null;
    }
    MiniPie localMiniPie2 = localMiniPie1;
    if (localMiniPie1 == null)
    {
      localMiniPie2 = MiniPieFactory.a(paramMultiAIOItemFragment.getBaseActivity(), paramMultiAIOItemFragment.a(), paramMultiAIOItemFragment.getBaseActivity().app);
      a(i, localMiniPie2);
    }
    return localMiniPie2;
  }
  
  public MultiAioContainer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMultiaioViewMultiAioContainer;
  }
  
  public List<RecentBaseData> a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRecentUserList() called with: app = [");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append("], activity = [");
      ((StringBuilder)localObject).append(paramBaseActivity);
      ((StringBuilder)localObject).append("], openedFrom = [");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], enteranceType = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], enteranceUin = [");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], enterNickName = [");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("], mRecentUserList = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilList);
      QLog.d("MultiAioContext", 2, ((StringBuilder)localObject).toString());
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    Object localObject = localList;
    if (localList == null)
    {
      localObject = MultiAIOHelper.a(paramBaseActivity, paramQQAppInterface, paramString1, paramInt, paramString2, paramString3);
      a((List)localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "destroy() called");
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(this);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, MiniPie paramMiniPie)
  {
    while (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
      this.jdField_a_of_type_JavaUtilList.add(null);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMiniPie() called with: position = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], miniPie = [");
      localStringBuilder.append(paramMiniPie);
      localStringBuilder.append("]");
      QLog.d("MultiAioContext", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, paramMiniPie);
  }
  
  public void a(Intent paramIntent)
  {
    MultiAioCaller localMultiAioCaller = this.jdField_a_of_type_ComTencentMobileqqMultiaioViewMultiAioCaller;
    if (localMultiAioCaller != null) {
      localMultiAioCaller.a(paramIntent);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDecorViewBitmap() called with: decorViewBitmap = [");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append("]");
      QLog.d("MultiAioContext", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt)
  {
    while (paramInt > 0)
    {
      a(paramLayoutInflater.inflate(2131558839, paramViewGroup, false));
      paramInt -= 1;
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("putCacheView() called size = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      localStringBuilder.append(" with: v = [");
      localStringBuilder.append(paramView);
      localStringBuilder.append("]");
      QLog.d("MultiAioContext", 2, localStringBuilder.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getRecentThreadLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this);
    this.jdField_a_of_type_AndroidOsHandler.postAtTime(new MultiAioContext.1(this, paramBaseActivity, paramQQAppInterface, paramString1, paramInt, paramString2, paramString3), this, 0L);
  }
  
  public void a(MultiAioCaller paramMultiAioCaller)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioViewMultiAioCaller = paramMultiAioCaller;
  }
  
  public void a(MultiAioContainer paramMultiAioContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioViewMultiAioContainer = paramMultiAioContainer;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Bitmap b()
  {
    return this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
  
  public void b()
  {
    MultiAioContainer localMultiAioContainer = this.jdField_a_of_type_ComTencentMobileqqMultiaioViewMultiAioContainer;
    if (localMultiAioContainer != null) {
      localMultiAioContainer.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Bitmap c()
  {
    return this.jdField_c_of_type_AndroidGraphicsBitmap;
  }
  
  public void c(Bitmap paramBitmap)
  {
    this.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.presenter.MultiAioContext
 * JD-Core Version:    0.7.0.1
 */
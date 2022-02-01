import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.ui.QAVPtvTemplateAdapter.6;
import com.tencent.av.ui.QAVPtvTemplateAdapter.7;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavPtvTemplateItemView;
import com.tencent.av.ui.VoiceChangeItemView2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class mhn
  extends BaseAdapter
{
  public static int a;
  public static int b;
  public static int c;
  float jdField_a_of_type_Float = 6.25F;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private View jdField_a_of_type_AndroidViewView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public HorizontalListView a;
  public ArrayList<min> a;
  mht jdField_a_of_type_Mht;
  mhu jdField_a_of_type_Mhu;
  private mil jdField_a_of_type_Mil = new mhr(this);
  private mim jdField_a_of_type_Mim = new mhs(this);
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  public boolean c;
  public volatile int d = -1;
  protected int e = -1;
  
  public mhn(AppInterface paramAppInterface, Context paramContext, ArrayList<min> paramArrayList, HorizontalListView paramHorizontalListView)
  {
    this(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView, 6.25F);
  }
  
  public mhn(AppInterface paramAppInterface, Context paramContext, ArrayList<min> paramArrayList, HorizontalListView paramHorizontalListView, float paramFloat)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_Float = paramFloat;
    a(paramArrayList);
    jdField_a_of_type_Int = a(this.jdField_a_of_type_AndroidContentResResources, a());
    jdField_b_of_type_Int = a(this.jdField_a_of_type_AndroidContentResResources, a(), 0.1666667F);
    jdField_c_of_type_Int = jdField_a_of_type_Int + AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_a_of_type_Float < 6.0F) {
      jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297604);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("QAVPtvTemplateAdapter", 4, "init, w[" + jdField_a_of_type_Int + "], h[" + jdField_c_of_type_Int + "], half[" + jdField_b_of_type_Int + "]");
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.addOnLayoutChangeListener(new mho(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new mhp(this));
    paramAppInterface = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams();
    paramAppInterface.width = -1;
    paramAppInterface.height = jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setLayoutParams(paramAppInterface);
  }
  
  public static int a(Resources paramResources, float paramFloat)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat + 0.5F);
  }
  
  public static int a(Resources paramResources, float paramFloat1, float paramFloat2)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public min a()
  {
    if ((this.e < 0) || (this.e >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (min)this.jdField_a_of_type_JavaUtilArrayList.get(this.e);
  }
  
  public min a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (min)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() >= paramInt) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPositionFromLeftOrRight(paramInt, 0, 200);
    }
    View localView;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition() > paramInt);
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt);
    } while ((localView != null) && (localView.getRight() <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getRight()));
    if (paramInt == getCount() - 1) {}
    for (int i = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels - jdField_a_of_type_Int;; i = jdField_a_of_type_Int * 5)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPositionFromLeftOrRight(paramInt, -i, 200);
      return;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      View localView1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt1);
      View localView2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt2);
      if ((paramInt2 != paramInt1) && (localView1 != null) && ((localView1 instanceof QavListItemBase))) {
        ((QavListItemBase)localView1).setHighlight(false);
      }
      if ((localView2 != null) && ((localView2 instanceof QavListItemBase))) {
        ((QavListItemBase)localView2).setHighlight(true);
      }
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt)) {}
    min localmin;
    do
    {
      return;
      localmin = (min)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((TextUtils.isEmpty(localmin.jdField_a_of_type_JavaLangString)) || (localmin.jdField_a_of_type_JavaLangString.equals("0")))
      {
        a(paramLong, localmin);
        return;
      }
      if (localmin.jdField_a_of_type_Boolean)
      {
        a(paramLong, localmin);
        return;
      }
    } while ((localmin.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(localmin.jdField_a_of_type_JavaLangString)));
    if (this.jdField_a_of_type_Mhu != null)
    {
      this.jdField_a_of_type_Mhu.startDownloadTemplate(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong, localmin, this.jdField_a_of_type_Mim);
      localmin.jdField_b_of_type_Boolean = true;
      return;
    }
    throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new QAVPtvTemplateAdapter.6(this, paramString, paramBoolean, paramLong));
  }
  
  public void a(long paramLong, min parammin)
  {
    if (this.jdField_a_of_type_Mht == null) {}
    while ((!TextUtils.isEmpty(parammin.jdField_a_of_type_JavaLangString)) && (!parammin.jdField_a_of_type_JavaLangString.equals("0")) && (!parammin.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Mht.a(paramLong, parammin);
  }
  
  void a(View paramView, min parammin, int paramInt)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.findViewById(2131373501);
    } while ((paramView == null) || (parammin == null));
    paramView.setContentDescription(parammin.d);
    ViewCompat.setAccessibilityDelegate(paramView, new mhq(this, paramInt));
  }
  
  public void a(String paramString, int paramInt)
  {
    c(paramString, paramInt);
  }
  
  public void a(ArrayList<min> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public void a(mht parammht)
  {
    this.jdField_a_of_type_Mht = parammht;
  }
  
  public void a(mhu parammhu)
  {
    this.jdField_a_of_type_Mhu = parammhu;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    int i = this.d;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    boolean bool1 = bool2;
    if (this.d != paramInt)
    {
      bool1 = bool2;
      if (paramInt >= 0)
      {
        bool1 = bool2;
        if (paramInt < j)
        {
          this.d = paramInt;
          notifyDataSetChanged();
          bool1 = true;
        }
      }
    }
    QLog.w("QAVPtvTemplateAdapter", 1, "setSelectedIndex, ret[" + bool1 + "], index[" + paramInt + "], mCurSelectedPosition[" + i + "->" + this.d + "], size[" + j + "]");
    return bool1;
  }
  
  public void b(String paramString, int paramInt)
  {
    min localmin2 = null;
    int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int n = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = k;
    Object localObject;
    min localmin1;
    for (;;)
    {
      if (i <= n) {
        if (i < 0)
        {
          i += 1;
        }
        else if (i >= this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = null;
          localmin1 = localmin2;
        }
      }
    }
    for (;;)
    {
      label59:
      int j;
      label134:
      label145:
      if ((localmin1 == null) && (paramInt == 101))
      {
        int m = this.jdField_a_of_type_JavaUtilArrayList.size();
        j = 0;
        label82:
        if ((j < k) && (j < m))
        {
          localmin2 = (min)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if ((localmin2 != null) && (localmin2.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            i = j;
            localmin1 = localmin2;
            if (localmin1 != null) {
              break label407;
            }
            j = n + 1;
            if (j >= m) {
              break label407;
            }
            localmin2 = (min)this.jdField_a_of_type_JavaUtilArrayList.get(j);
            if ((localmin2 == null) || (!localmin2.jdField_a_of_type_JavaLangString.equals(paramString))) {
              break label355;
            }
            localmin1 = localmin2;
            i = j;
          }
        }
      }
      for (;;)
      {
        if (localmin1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateManager", 2, String.format("onProgressUpdate, index[%s], [%s][%s], progress[%s]", new Object[] { Integer.valueOf(i), localmin1.jdField_a_of_type_JavaLangString, localmin1.c, Integer.valueOf(paramInt) }));
          }
          if (paramInt != -1) {
            break label364;
          }
          localmin1.jdField_b_of_type_Boolean = false;
        }
        for (;;)
        {
          if (localObject != null) {
            ((QavListItemBase)localObject).a(paramInt);
          }
          return;
          localmin1 = (min)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localmin1 == null) || (!localmin1.jdField_a_of_type_JavaLangString.equals(paramString))) {
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - k);
          if ((!(localObject instanceof QavListItemBase)) || (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter().equals(this))) {
            break label416;
          }
          localObject = (QavListItemBase)localObject;
          break label59;
          j += 1;
          break label82;
          label355:
          j += 1;
          break label145;
          label364:
          if (paramInt == 101)
          {
            localmin1.jdField_b_of_type_Boolean = false;
            localmin1.jdField_a_of_type_Boolean = true;
          }
          else
          {
            i = paramInt;
            if (paramInt == 100) {
              i = 99;
            }
            localmin1.jdField_b_of_type_Boolean = true;
            paramInt = i;
          }
        }
        label407:
        continue;
        break label134;
      }
      label416:
      localObject = null;
      continue;
      localObject = null;
      localmin1 = localmin2;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QAVPtvTemplateAdapter.7(this, paramString, paramInt));
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    boolean bool = true;
    min localmin = a(paramInt);
    Object localObject1;
    if (localmin == null)
    {
      a(paramView, null, paramInt);
      localObject1 = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      if (!"-1".equals(localmin.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject1 = localObject2;
      if (paramView != null)
      {
        localObject1 = localObject2;
        if (paramView.getId() == Integer.valueOf(localmin.jdField_a_of_type_JavaLangString).intValue()) {
          localObject1 = paramView;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_AndroidViewView != null) {
          localObject2 = this.jdField_a_of_type_AndroidViewView;
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new View(this.jdField_a_of_type_AndroidContentContext);
        ((View)localObject1).setId(Integer.valueOf(localmin.jdField_a_of_type_JavaLangString).intValue());
        ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(jdField_b_of_type_Int, -1));
        this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      }
      if (AudioHelper.a(0) == 1) {
        ((View)localObject1).setBackgroundColor(-256);
      }
    }
    label226:
    label237:
    int i;
    if (!(paramView instanceof QavListItemBase)) {
      if (localmin.jdField_a_of_type_Int == 2)
      {
        localObject1 = new VoiceChangeItemView2(this.jdField_a_of_type_AndroidContentContext);
        ((QavListItemBase)localObject1).a(jdField_a_of_type_Int, jdField_c_of_type_Int);
        if (AudioHelper.a(0) == 1)
        {
          ((QavListItemBase)localObject1).a(localmin, paramInt);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundColor(-1);
          QLog.w("QAVPtvTemplateAdapter", 1, "getView, itemView[" + localObject1.hashCode() + "], mListView[" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.hashCode() + "], position[" + paramInt + "], getPosition[" + ((QavListItemBase)localObject1).a() + "], mFullItemWidth[" + jdField_a_of_type_Int + "], mListViewHeight[" + jdField_c_of_type_Int + "], mListView.Height[" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight() + "|" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight() + "], itemView.Height[" + ((QavListItemBase)localObject1).getMeasuredHeight() + "|" + ((QavListItemBase)localObject1).getHeight() + "], info[" + localmin + "]");
        }
        ((QavListItemBase)localObject1).b(jdField_a_of_type_Int, jdField_c_of_type_Int);
        if (paramInt != this.d) {
          break label567;
        }
        i = 1;
        label453:
        if ((!this.jdField_a_of_type_Boolean) || (i == 0)) {
          break label573;
        }
      }
    }
    for (;;)
    {
      ((QavListItemBase)localObject1).a(paramInt, bool, this.jdField_b_of_type_Boolean, localmin, this.jdField_a_of_type_Mil);
      a((View)localObject1, localmin, paramInt);
      break;
      localObject1 = new QavPtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      ((QavPtvTemplateItemView)localObject1).jdField_a_of_type_Boolean = this.jdField_c_of_type_Boolean;
      if (this.jdField_a_of_type_Float < 6.0F)
      {
        localObject2 = ((QavPtvTemplateItemView)localObject1).findViewById(2131373667);
        if ((localObject2 instanceof LinearLayout)) {
          ((LinearLayout)localObject2).setGravity(49);
        }
      }
      break label226;
      localObject1 = (QavListItemBase)paramView;
      break label237;
      label567:
      i = 0;
      break label453;
      label573:
      bool = false;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mhn
 * JD-Core Version:    0.7.0.1
 */
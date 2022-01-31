import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.ui.QAVPtvTemplateAdapter.5;
import com.tencent.av.ui.QAVPtvTemplateAdapter.6;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavPtvTemplateItemView;
import com.tencent.av.ui.VoiceChangeItemView2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class mjk
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
  public ArrayList<mkj> a;
  mjp jdField_a_of_type_Mjp;
  mjq jdField_a_of_type_Mjq;
  private mkh jdField_a_of_type_Mkh = new mjn(this);
  private mki jdField_a_of_type_Mki = new mjo(this);
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  public boolean c;
  public int d = -1;
  
  public mjk(AppInterface paramAppInterface, Context paramContext, ArrayList<mkj> paramArrayList, HorizontalListView paramHorizontalListView)
  {
    this(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView, 6.25F);
  }
  
  public mjk(AppInterface paramAppInterface, Context paramContext, ArrayList<mkj> paramArrayList, HorizontalListView paramHorizontalListView, float paramFloat)
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
    jdField_c_of_type_Int = jdField_a_of_type_Int + aepi.a(30.0F, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_a_of_type_Float < 6.0F) {
      jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297457);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("QAVPtvTemplateAdapter", 4, "init, w[" + jdField_a_of_type_Int + "], h[" + jdField_c_of_type_Int + "], half[" + jdField_b_of_type_Int + "]");
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.addOnLayoutChangeListener(new mjl(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new mjm(this));
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
  
  public mkj a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (mkj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
    mkj localmkj;
    do
    {
      return;
      localmkj = (mkj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((TextUtils.isEmpty(localmkj.jdField_a_of_type_JavaLangString)) || (localmkj.jdField_a_of_type_JavaLangString.equals("0")))
      {
        a(paramLong, localmkj);
        return;
      }
      if (localmkj.jdField_a_of_type_Boolean)
      {
        a(paramLong, localmkj);
        return;
      }
    } while ((localmkj.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(localmkj.jdField_a_of_type_JavaLangString)));
    if (this.jdField_a_of_type_Mjq != null)
    {
      this.jdField_a_of_type_Mjq.startDownloadTemplate(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong, localmkj, this.jdField_a_of_type_Mki);
      localmkj.jdField_b_of_type_Boolean = true;
      return;
    }
    throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new QAVPtvTemplateAdapter.5(this, paramString, paramBoolean, paramLong));
  }
  
  public void a(long paramLong, mkj parammkj)
  {
    if (this.jdField_a_of_type_Mjp == null) {}
    while ((!TextUtils.isEmpty(parammkj.jdField_a_of_type_JavaLangString)) && (!parammkj.jdField_a_of_type_JavaLangString.equals("0")) && (!parammkj.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Mjp.a(paramLong, parammkj);
  }
  
  void a(View paramView, mkj parammkj)
  {
    if (paramView == null) {}
    View localView;
    do
    {
      return;
      localView = paramView.findViewById(2131372634);
      if (parammkj == null) {
        paramView.setContentDescription(null);
      }
    } while (localView == null);
    localView.setContentDescription(null);
  }
  
  public void a(String paramString, int paramInt)
  {
    c(paramString, paramInt);
  }
  
  public void a(ArrayList<mkj> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public void a(mjp parammjp)
  {
    this.jdField_a_of_type_Mjp = parammjp;
  }
  
  public void a(mjq parammjq)
  {
    this.jdField_a_of_type_Mjq = parammjq;
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
    mkj localmkj2 = null;
    int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int n = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = k;
    Object localObject;
    mkj localmkj1;
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
          localmkj1 = localmkj2;
        }
      }
    }
    for (;;)
    {
      label59:
      int j;
      label134:
      label145:
      if ((localmkj1 == null) && (paramInt == 101))
      {
        int m = this.jdField_a_of_type_JavaUtilArrayList.size();
        j = 0;
        label82:
        if ((j < k) && (j < m))
        {
          localmkj2 = (mkj)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if ((localmkj2 != null) && (localmkj2.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            i = j;
            localmkj1 = localmkj2;
            if (localmkj1 != null) {
              break label407;
            }
            j = n + 1;
            if (j >= m) {
              break label407;
            }
            localmkj2 = (mkj)this.jdField_a_of_type_JavaUtilArrayList.get(j);
            if ((localmkj2 == null) || (!localmkj2.jdField_a_of_type_JavaLangString.equals(paramString))) {
              break label355;
            }
            localmkj1 = localmkj2;
            i = j;
          }
        }
      }
      for (;;)
      {
        if (localmkj1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateManager", 2, String.format("onProgressUpdate, index[%s], [%s][%s], progress[%s]", new Object[] { Integer.valueOf(i), localmkj1.jdField_a_of_type_JavaLangString, localmkj1.c, Integer.valueOf(paramInt) }));
          }
          if (paramInt != -1) {
            break label364;
          }
          localmkj1.jdField_b_of_type_Boolean = false;
        }
        for (;;)
        {
          if (localObject != null) {
            ((QavListItemBase)localObject).a(paramInt);
          }
          return;
          localmkj1 = (mkj)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localmkj1 == null) || (!localmkj1.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
            localmkj1.jdField_b_of_type_Boolean = false;
            localmkj1.jdField_a_of_type_Boolean = true;
          }
          else
          {
            i = paramInt;
            if (paramInt == 100) {
              i = 99;
            }
            localmkj1.jdField_b_of_type_Boolean = true;
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
      localmkj1 = localmkj2;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QAVPtvTemplateAdapter.6(this, paramString, paramInt));
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
    Object localObject = null;
    boolean bool = true;
    mkj localmkj = a(paramInt);
    if (localmkj == null) {
      a(paramView, null);
    }
    do
    {
      return paramView;
      if (!"-1".equals(localmkj.jdField_a_of_type_JavaLangString)) {
        break;
      }
      paramViewGroup = localObject;
      if (paramView != null)
      {
        paramViewGroup = localObject;
        if (paramView.getId() == Integer.valueOf(localmkj.jdField_a_of_type_JavaLangString).intValue()) {
          paramViewGroup = paramView;
        }
      }
      paramView = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_AndroidViewView != null) {
          paramView = this.jdField_a_of_type_AndroidViewView;
        }
      }
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(Integer.valueOf(localmkj.jdField_a_of_type_JavaLangString).intValue());
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(jdField_b_of_type_Int, -1));
        this.jdField_a_of_type_AndroidViewView = paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (AudioHelper.a(0) != 1);
    paramViewGroup.setBackgroundColor(-256);
    return paramViewGroup;
    label200:
    int i;
    if (!(paramView instanceof QavListItemBase)) {
      if (localmkj.jdField_a_of_type_Int == 2)
      {
        paramView = new VoiceChangeItemView2(this.jdField_a_of_type_AndroidContentContext);
        paramView.a(jdField_a_of_type_Int, jdField_c_of_type_Int);
        if (AudioHelper.a(0) == 1)
        {
          paramView.a(localmkj, paramInt);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundColor(-1);
          QLog.w("QAVPtvTemplateAdapter", 1, "getView, itemView[" + paramView.hashCode() + "], mListView[" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.hashCode() + "], position[" + paramInt + "], getPosition[" + paramView.a() + "], mFullItemWidth[" + jdField_a_of_type_Int + "], mListViewHeight[" + jdField_c_of_type_Int + "], mListView.Height[" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight() + "|" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight() + "], itemView.Height[" + paramView.getMeasuredHeight() + "|" + paramView.getHeight() + "], info[" + localmkj + "]");
        }
        paramView.b(jdField_a_of_type_Int, jdField_c_of_type_Int);
        if (paramInt != this.d) {
          break label513;
        }
        i = 1;
        label410:
        if ((!this.jdField_a_of_type_Boolean) || (i == 0)) {
          break label519;
        }
      }
    }
    for (;;)
    {
      paramView.a(paramInt, bool, this.jdField_b_of_type_Boolean, localmkj, this.jdField_a_of_type_Mkh);
      a(paramView, localmkj);
      return paramView;
      paramView = new QavPtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.jdField_a_of_type_Boolean = this.jdField_c_of_type_Boolean;
      if (this.jdField_a_of_type_Float < 6.0F)
      {
        paramViewGroup = paramView.findViewById(2131372798);
        if ((paramViewGroup instanceof LinearLayout)) {
          ((LinearLayout)paramViewGroup).setGravity(49);
        }
      }
      break;
      paramView = (QavListItemBase)paramView;
      break label200;
      label513:
      i = 0;
      break label410;
      label519:
      bool = false;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mjk
 * JD-Core Version:    0.7.0.1
 */
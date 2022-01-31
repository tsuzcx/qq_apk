import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class stn
  extends BaseAdapter
  implements bdbc, sub
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e = 1;
  private static int h;
  private float jdField_a_of_type_Float;
  private ajjp jdField_a_of_type_Ajjp;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<sut> jdField_a_of_type_JavaUtilList = new ArrayList();
  private sty jdField_a_of_type_Sty;
  private suk jdField_a_of_type_Suk;
  public boolean a;
  private float jdField_b_of_type_Float;
  private List<ReadInJoyArticle> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  private float jdField_c_of_type_Float;
  private List<Object> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  public int f = -1;
  public int g = -1;
  private final int i = 10;
  private int j;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    h = 3;
  }
  
  public stn(Activity paramActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_Ajjp = new ajjp(paramQQAppInterface, this, false);
    this.jdField_c_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297839);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297841);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297840);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297838);
  }
  
  private void a(stp paramstp, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramstp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Ajjp.a(1008, paramString));
      return;
    }
    paramstp.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {
      azqs.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.jdField_a_of_type_JavaUtilHashSet.size(), 0, "", "", "", "");
    }
    if (this.j > 0) {
      azqs.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, this.j, 0, "", "", "", "");
    }
    if (this.jdField_d_of_type_Boolean) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilHashSet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_Sty = null;
    this.jdField_a_of_type_Suk = null;
    this.jdField_a_of_type_Ajjp.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List<sut> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(sty paramsty)
  {
    this.jdField_a_of_type_Sty = paramsty;
  }
  
  public void a(suk paramsuk)
  {
    this.jdField_a_of_type_Suk = paramsuk;
  }
  
  public boolean a(ImageView paramImageView)
  {
    if (paramImageView.getTag(2131377253).equals(Integer.valueOf(jdField_b_of_type_Int))) {
      return true;
    }
    if (paramImageView.getTag(2131377253).equals(Integer.valueOf(jdField_a_of_type_Int)))
    {
      int m = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int k = 0;
      if (k < m)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(k).getTag();
        if ((localObject == null) || (!(localObject instanceof stp))) {}
        while (!((stp)localObject).jdField_a_of_type_JavaLangString.equals(paramImageView.getTag(2131377254)))
        {
          k += 1;
          break;
        }
        return true;
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    int m = 1;
    int k;
    if ((this.f == 1) && (this.jdField_a_of_type_Boolean))
    {
      k = 1;
      if ((this.g != 1) || (!this.jdField_b_of_type_Boolean)) {
        break label136;
      }
      label34:
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      if ((k != 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        if (this.jdField_c_of_type_JavaUtilList.size() > 6) {
          break label141;
        }
        this.jdField_c_of_type_JavaUtilList.add("ReadInJoyArticle");
      }
    }
    for (;;)
    {
      if (m != 0)
      {
        if (this.jdField_c_of_type_JavaUtilList.size() > 3) {
          break label158;
        }
        this.jdField_c_of_type_JavaUtilList.add("SubscriptRecommendController");
      }
      return;
      k = 0;
      break;
      label136:
      m = 0;
      break label34;
      label141:
      this.jdField_c_of_type_JavaUtilList.add(6, "ReadInJoyArticle");
    }
    label158:
    this.jdField_c_of_type_JavaUtilList.add(3, "SubscriptRecommendController");
  }
  
  public void b(List<ReadInJoyArticle> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_c_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_c_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k = h;
    Object localObject = this.jdField_c_of_type_JavaUtilList.get(paramInt);
    if ((localObject instanceof sut)) {
      paramInt = jdField_a_of_type_Int;
    }
    do
    {
      do
      {
        return paramInt;
        if (((localObject instanceof String)) && (localObject.equals("SubscriptRecommendController"))) {
          return jdField_c_of_type_Int;
        }
        paramInt = k;
      } while (!(localObject instanceof String));
      paramInt = k;
    } while (!localObject.equals("ReadInJoyArticle"));
    return jdField_b_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_c_of_type_JavaUtilList.size())) {
      return null;
    }
    int m = getItemViewType(paramInt);
    paramViewGroup = null;
    int k;
    if (paramView == null) {
      if (m == jdField_a_of_type_Int)
      {
        paramViewGroup = new stp(this);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560210, null);
        paramViewGroup.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131377242));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377256));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377261));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375630));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131379325));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366191));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366163));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366167));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370215));
        paramViewGroup.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370221));
        paramViewGroup.jdField_c_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370220));
        paramViewGroup.d = ((Button)paramView.findViewById(2131370199));
        paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramViewGroup.jdField_c_of_type_AndroidWidgetTextView;
        if (this.jdField_c_of_type_Boolean)
        {
          k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166004);
          ((TextView)localObject1).setTextColor(k);
          localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if (!this.jdField_c_of_type_Boolean) {
            break label437;
          }
          k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166010);
          label361:
          ((TextView)localObject1).setTextColor(k);
          localObject1 = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
          if (!this.jdField_c_of_type_Boolean) {
            break label452;
          }
          k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166013);
          label393:
          ((TextView)localObject1).setTextColor(k);
          label400:
          localObject1 = paramView;
          if (paramView != null) {
            paramView.setTag(paramViewGroup);
          }
        }
      }
    }
    for (Object localObject1 = paramView;; localObject1 = paramView)
    {
      if (localObject1 == null)
      {
        return null;
        k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166003);
        break;
        label437:
        k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166009);
        break label361;
        label452:
        k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166012);
        break label393;
        if (m == jdField_b_of_type_Int)
        {
          paramViewGroup = new stq(this, null);
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560212, null);
          paramViewGroup.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369035));
          paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject1 = (TextView)paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369036);
          int n;
          if (!this.jdField_c_of_type_Boolean)
          {
            k = 2130842819;
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, k, 0);
            paramViewGroup.jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131369019));
            paramViewGroup.jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131369020));
            paramViewGroup.jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131369021));
            paramViewGroup.jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131369022));
            n = paramViewGroup.jdField_a_of_type_JavaUtilArrayList.size();
            localObject1 = this.jdField_a_of_type_AndroidContentResResources;
            if (this.jdField_c_of_type_Boolean) {
              break label743;
            }
          }
          label743:
          for (k = 2131166019;; k = 2131166020)
          {
            int i1 = ((Resources)localObject1).getColor(k);
            k = 0;
            while (k < n)
            {
              localObject1 = (ViewGroup)paramViewGroup.jdField_a_of_type_JavaUtilArrayList.get(k);
              ((ViewGroup)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject1).setTag(Integer.valueOf(k));
              ((TextView)((ViewGroup)localObject1).findViewById(2131362860)).setTextColor(i1);
              k += 1;
            }
            k = 2130842820;
            break;
          }
          paramView.setTag(-3, Integer.valueOf(0));
          break label400;
        }
        if (m != jdField_c_of_type_Int) {
          break label1993;
        }
        paramViewGroup = new str(this, null);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560214, null);
        this.jdField_a_of_type_Suk.a(paramView);
        this.jdField_a_of_type_Suk.b();
        this.jdField_a_of_type_Suk.h();
        paramView.setTag(-3, Integer.valueOf(0));
        this.jdField_d_of_type_Boolean = true;
        break label400;
      }
      Object localObject2;
      label970:
      Object localObject3;
      if (m == jdField_a_of_type_Int)
      {
        ((View)localObject1).setTag(2131377248, Integer.valueOf(paramInt));
        paramView = (stp)((View)localObject1).getTag();
        paramViewGroup = (sut)getItem(paramInt);
        if (this.jdField_a_of_type_JavaUtilHashSet != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(paramViewGroup.jdField_a_of_type_JavaLangString);
        }
        paramView.jdField_a_of_type_JavaLangString = paramViewGroup.jdField_a_of_type_JavaLangString;
        a(paramView, paramViewGroup.jdField_a_of_type_JavaLangString);
        localObject2 = suv.a().a(paramViewGroup.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText(ajlh.a().a(paramViewGroup.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_Long));
          if (paramViewGroup.jdField_b_of_type_Int <= 0) {
            break label1304;
          }
          k = 3;
          bhvv.a(paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, paramViewGroup.jdField_b_of_type_Int, 2130849805, 99, null);
          if (paramViewGroup.jdField_a_of_type_JavaUtilList.size() <= 0) {
            break label1659;
          }
          localObject3 = (suu)paramViewGroup.jdField_a_of_type_JavaUtilList.get(0);
          if (((suu)localObject3).jdField_a_of_type_Int != 0) {
            break label1310;
          }
          paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
          paramView.jdField_c_of_type_AndroidWidgetTextView.setText(new bamp(((suu)localObject3).c.replaceFirst("^\\s+", ""), 3, 20));
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          label1080:
          paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131377245, Integer.valueOf(paramViewGroup.jdField_b_of_type_Int));
          paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131377254, paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131377247, localObject2);
          paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131377246, Integer.valueOf(jdField_d_of_type_Int));
          paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377245, paramViewGroup);
          paramView.jdField_a_of_type_AndroidWidgetButton.setTag(2131377254, paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_b_of_type_AndroidWidgetButton.setTag(2131377254, paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_c_of_type_AndroidWidgetButton.setTag(2131377254, paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_c_of_type_AndroidWidgetButton.setTag(2131377247, localObject2);
          paramView.d.setTag(2131377254, paramViewGroup.jdField_a_of_type_JavaLangString);
          if (suv.a().a(paramViewGroup.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label1697;
          }
          if (this.jdField_c_of_type_Boolean) {
            break label1684;
          }
          paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130842815);
          label1247:
          ((View)localObject1).setTag(-3, Integer.valueOf((int)(this.jdField_a_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
          paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramView.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
      }
      for (;;)
      {
        return localObject1;
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        break;
        label1304:
        k = 0;
        break label970;
        label1310:
        ViewGroup.LayoutParams localLayoutParams;
        if (((suu)localObject3).jdField_a_of_type_Int == 1)
        {
          paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
          paramView.jdField_c_of_type_AndroidWidgetTextView.setText(((suu)localObject3).b.replaceFirst("^\\s+", ""));
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          if (TextUtils.isEmpty(((suu)localObject3).g)) {
            paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          for (;;)
          {
            paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(2131377254, paramView.jdField_a_of_type_JavaLangString);
            paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(2131377253, Integer.valueOf(jdField_a_of_type_Int));
            localLayoutParams = paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
            this.jdField_a_of_type_Sty.a(swu.a(((suu)localObject3).jdField_a_of_type_JavaLangString, 1, paramViewGroup.jdField_a_of_type_JavaLangString), paramView.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams.width, localLayoutParams.height, this);
            if (!(paramView.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof URLDrawable)) {
              break;
            }
            localObject3 = (URLDrawable)paramView.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
            if (paramInt < 10) {
              break;
            }
            ((URLDrawable)localObject3).setAutoDownload(false);
            break;
            paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
        if (((suu)localObject3).jdField_a_of_type_Int == 2)
        {
          paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
          paramView.jdField_c_of_type_AndroidWidgetTextView.setText(2131696976);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(2131377254, paramView.jdField_a_of_type_JavaLangString);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(2131377253, Integer.valueOf(jdField_a_of_type_Int));
          localLayoutParams = paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          this.jdField_a_of_type_Sty.a(swu.a(((suu)localObject3).jdField_a_of_type_JavaNetURL.toString(), 1, paramViewGroup.jdField_a_of_type_JavaLangString), paramView.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams.width, localLayoutParams.height, this);
          break label1080;
        }
        paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramView.jdField_c_of_type_AndroidWidgetTextView.setText(2131696977);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        break label1080;
        label1659:
        if ((!QLog.isColorLevel()) || (!QLog.isColorLevel())) {
          break label1080;
        }
        QLog.w("SubscriptFeedsAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
        break label1080;
        label1684:
        paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130842817);
        break label1247;
        label1697:
        if (!this.jdField_c_of_type_Boolean) {
          paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130842816);
        }
        for (;;)
        {
          ((View)localObject1).setTag(-3, Integer.valueOf((int)(this.jdField_b_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
          paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramView.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          break;
          paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130842818);
        }
        if (m == jdField_b_of_type_Int)
        {
          ((View)localObject1).setTag(2131377248, Integer.valueOf(paramInt));
          this.j += 1;
          paramView = (stq)((View)localObject1).getTag();
          k = paramView.jdField_a_of_type_JavaUtilArrayList.size();
          paramInt = 0;
          while (paramInt < k)
          {
            localObject2 = (ViewGroup)paramView.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            paramViewGroup = (TextView)((ViewGroup)localObject2).findViewById(2131362860);
            localObject2 = (ImageView)((ViewGroup)localObject2).findViewById(2131362859);
            if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
            {
              localObject3 = (ReadInJoyArticle)this.jdField_b_of_type_JavaUtilList.get(paramInt);
              paramViewGroup.setText(((ReadInJoyArticle)localObject3).mTitle.replaceFirst("^\\s+", ""));
              ((ImageView)localObject2).setTag(2131377253, Integer.valueOf(jdField_b_of_type_Int));
              paramViewGroup = (WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window");
              this.jdField_a_of_type_Sty.a(swu.a(((ReadInJoyArticle)localObject3).mFirstPagePicUrl, 1), (ImageView)localObject2, paramViewGroup.getDefaultDisplay().getWidth(), paramViewGroup.getDefaultDisplay().getHeight(), this);
            }
            paramInt += 1;
          }
        }
        else if (m != jdField_c_of_type_Int) {}
      }
      label1993:
      break label400;
    }
  }
  
  public int getViewTypeCount()
  {
    return h;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof stp)))
        {
          paramBitmap = (stp)paramBitmap;
          if (paramString.equals(paramBitmap.jdField_a_of_type_JavaLangString)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     stn
 * JD-Core Version:    0.7.0.1
 */
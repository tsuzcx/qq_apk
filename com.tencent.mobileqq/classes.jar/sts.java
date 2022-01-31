import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class sts
  extends BaseAdapter
  implements bdbc
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private static int e;
  private float jdField_a_of_type_Float;
  private ajjp jdField_a_of_type_Ajjp;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<sut> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private List<Object> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private List<stu> jdField_c_of_type_JavaUtilList = new ArrayList();
  private float d;
  private int f;
  
  static
  {
    jdField_b_of_type_Int = 1;
    e = 3;
    jdField_d_of_type_Int = 1;
  }
  
  public sts(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_Ajjp = new ajjp(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297839);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297841);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297840);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297838);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    b();
  }
  
  private void a(stt paramstt, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramstt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Ajjp.a(1008, paramString));
      return;
    }
    paramstt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty())
    {
      azqs.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.jdField_a_of_type_JavaUtilHashSet.size(), 0, "", "", "", "");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label128;
        }
        String str = (String)localIterator.next();
        Object localObject1 = "";
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("folder_status", ors.jdField_d_of_type_Int);
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        nrt.a(null, str, "0X80081C7", "0X80081C7", 0, 0, "", "", "", (String)localObject1, false);
      }
    }
    label128:
    if (this.f > 0) {
      azqs.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, this.f, 0, "", "", "", "");
    }
    if (this.jdField_b_of_type_Boolean) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilHashSet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_Ajjp.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList = null;
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
  
  public void b()
  {
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    ArrayList localArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList.addAll(localArrayList);
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_c_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = e;
    Object localObject = this.jdField_b_of_type_JavaUtilList.get(paramInt);
    if ((localObject instanceof sut)) {
      paramInt = jdField_a_of_type_Int;
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (!(localObject instanceof stu));
    return jdField_b_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilList.size())) {
      return null;
    }
    int j = getItemViewType(paramInt);
    Object localObject = null;
    int i;
    if (paramView == null) {
      if (j == jdField_a_of_type_Int)
      {
        localObject = new stt(this);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560211, null);
        ((stt)localObject).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131377242));
        ((stt)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377256));
        ((stt)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377261));
        ((stt)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375630));
        ((stt)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131379325));
        ((stt)localObject).c = ((TextView)paramView.findViewById(2131366191));
        ((stt)localObject).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370220));
        ((stt)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370199));
        ((stt)localObject).jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((stt)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        ((stt)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((stt)localObject).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((stt)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup = ((stt)localObject).c;
        if (this.jdField_a_of_type_Boolean)
        {
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166004);
          paramViewGroup.setTextColor(i);
          paramViewGroup = ((stt)localObject).jdField_a_of_type_AndroidWidgetTextView;
          if (!this.jdField_a_of_type_Boolean) {
            break label376;
          }
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166010);
          label297:
          paramViewGroup.setTextColor(i);
          paramViewGroup = ((stt)localObject).jdField_b_of_type_AndroidWidgetTextView;
          if (!this.jdField_a_of_type_Boolean) {
            break label391;
          }
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166013);
          label328:
          paramViewGroup.setTextColor(i);
          label334:
          paramViewGroup = paramView;
          if (paramView != null)
          {
            paramViewGroup = paramView;
            if (localObject != null) {
              paramView.setTag(localObject);
            }
          }
        }
      }
    }
    for (paramViewGroup = paramView;; paramViewGroup = paramView)
    {
      if (paramViewGroup == null)
      {
        return null;
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166009);
        break;
        label376:
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166003);
        break label297;
        label391:
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166012);
        break label328;
        if (j != jdField_b_of_type_Int) {
          break label1196;
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559848, null);
        break label334;
      }
      if (j == jdField_a_of_type_Int)
      {
        paramViewGroup.setTag(2131377248, Integer.valueOf(paramInt));
        localObject = (stt)paramViewGroup.getTag();
        localsut = (sut)getItem(paramInt);
        if (this.jdField_a_of_type_JavaUtilHashSet != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localsut.jdField_a_of_type_JavaLangString);
        }
        ((stt)localObject).jdField_a_of_type_JavaLangString = localsut.jdField_a_of_type_JavaLangString;
        a((stt)localObject, localsut.jdField_a_of_type_JavaLangString);
        paramView = suv.a().a(localsut.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(paramView))
        {
          paramView = suv.a().a(localsut.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (!TextUtils.isEmpty(paramView))
          {
            ((stt)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
            ((stt)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(ajlh.a().a(localsut.jdField_a_of_type_JavaLangString, localsut.jdField_a_of_type_Long));
            if (localsut.jdField_b_of_type_Int <= 0) {
              break label870;
            }
            paramInt = 3;
            bhvv.a(((stt)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, localsut.jdField_b_of_type_Int, 2130849805, 99, null);
            if (localsut.jdField_a_of_type_JavaUtilList.size() <= 0) {
              break label972;
            }
            localsuu = (suu)localsut.jdField_a_of_type_JavaUtilList.get(0);
            if (localsuu.jdField_a_of_type_Int != 0) {
              break label875;
            }
            ((stt)localObject).c.setMaxLines(1);
            ((stt)localObject).c.setText(new bamp(localsuu.c.replaceFirst("^\\s+", ""), 3, 20));
            ((stt)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(2131377245, Integer.valueOf(localsut.jdField_b_of_type_Int));
            ((stt)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(2131377254, localsut.jdField_a_of_type_JavaLangString);
            ((stt)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(2131377247, paramView);
            ((stt)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(2131377246, Integer.valueOf(jdField_c_of_type_Int));
            ((stt)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(localsut);
            ((stt)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377245, localsut);
            ((stt)localObject).jdField_a_of_type_AndroidWidgetButton.setTag(2131377254, localsut.jdField_a_of_type_JavaLangString);
            ((stt)localObject).jdField_a_of_type_AndroidWidgetButton.setTag(2131377247, paramView);
            ((stt)localObject).jdField_b_of_type_AndroidWidgetButton.setTag(2131377254, localsut.jdField_a_of_type_JavaLangString);
            paramViewGroup.setTag(-3, Integer.valueOf((int)(this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
          }
        }
      }
      label870:
      label875:
      while (j != jdField_b_of_type_Int) {
        for (;;)
        {
          sut localsut;
          suu localsuu;
          return paramViewGroup;
          ((stt)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localsut.jdField_a_of_type_JavaLangString);
          continue;
          ((stt)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
          continue;
          paramInt = 0;
          continue;
          if (localsuu.jdField_a_of_type_Int == 1)
          {
            ((stt)localObject).c.setMaxLines(2);
            ((stt)localObject).c.setText(localsuu.jdField_b_of_type_JavaLangString.replaceFirst("^\\s+", ""));
          }
          else if (localsuu.jdField_a_of_type_Int == 2)
          {
            ((stt)localObject).c.setMaxLines(1);
            ((stt)localObject).c.setText(2131696976);
          }
          else
          {
            ((stt)localObject).c.setMaxLines(1);
            ((stt)localObject).c.setText(2131696977);
            continue;
            if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
              QLog.w("SubscriptFeedsNewAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
            }
          }
        }
      }
      label972:
      paramView = (stu)getItem(paramInt);
      ((TextView)paramViewGroup.findViewById(2131370780)).setText(paramView.jdField_a_of_type_JavaLangString);
      ((ImageView)paramViewGroup.findViewById(2131370779)).setImageDrawable(paramView.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localObject = (DragTextView)paramViewGroup.findViewById(2131379325);
      ((DragTextView)localObject).setDragViewType(0, paramViewGroup);
      if (paramView.jdField_a_of_type_Int > 0) {}
      for (paramInt = 3;; paramInt = 0)
      {
        bhvv.a((TextView)localObject, paramInt, paramView.jdField_a_of_type_Int, 2130849805, 99, null);
        if (paramView.jdField_a_of_type_Int > 0) {
          paramViewGroup.findViewById(2131362838).setVisibility(8);
        }
        localObject = (ViewGroup)paramViewGroup.findViewById(2131370778);
        ((ViewGroup)localObject).setTag(2131377246, Integer.valueOf(jdField_d_of_type_Int));
        ((ViewGroup)localObject).setTag(2131377450, paramView.jdField_b_of_type_JavaLangString);
        ((ViewGroup)localObject).setTag(2131375242, Integer.valueOf(paramView.jdField_b_of_type_Int));
        ((ViewGroup)localObject).setTag(2131375243, Integer.valueOf(paramView.jdField_a_of_type_Int));
        ((ViewGroup)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break;
      }
      label1196:
      break label334;
    }
  }
  
  public int getViewTypeCount()
  {
    return e;
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
        if ((paramBitmap != null) && ((paramBitmap instanceof stt)))
        {
          paramBitmap = (stt)paramBitmap;
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
 * Qualified Name:     sts
 * JD-Core Version:    0.7.0.1
 */
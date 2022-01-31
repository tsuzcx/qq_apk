import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.Iterator;
import java.util.List;

public class pnh
  extends BaseAdapter
  implements bfpt
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<bbjs> jdField_a_of_type_JavaUtilList;
  private pni jdField_a_of_type_Pni;
  
  public pnh(Context paramContext, List<bbjs> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bbjs a(int paramInt)
  {
    bbjs localbbjs;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0))
    {
      localbbjs = null;
      return localbbjs;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label89;
      }
      localbbjs = (bbjs)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localbbjs != null)
      {
        k = j;
        if (localbbjs.d == 0) {
          k = j + 1;
        }
      }
      if (k == paramInt) {
        break;
      }
      i += 1;
      j = k;
    }
    label89:
    return null;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      bbjs localbbjs = (bbjs)localIterator.next();
      if ((localbbjs == null) || (localbbjs.d != 0)) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidContentResResources == null) {
      this.jdField_a_of_type_AndroidContentResResources = paramViewGroup.getContext().getResources();
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296669));
    }
    if (this.jdField_a_of_type_Pni == null) {
      this.jdField_a_of_type_Pni = new pni(paramViewGroup.getContext());
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559778, paramViewGroup, false);
      paramViewGroup = new awgr();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376008));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376009));
      paramView.setTag(paramViewGroup);
      paramView.setFocusable(true);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Bbjs = a(paramInt);
      if (paramViewGroup.jdField_a_of_type_Bbjs != null) {
        break;
      }
      QLog.e("NativeShareView", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      return paramView;
      paramViewGroup = (awgr)paramView.getTag();
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_Int);
    Object localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    Object localObject2 = paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_JavaLangString;
    if (paramViewGroup.jdField_a_of_type_Bbjs.e > 0)
    {
      paramInt = paramViewGroup.jdField_a_of_type_Bbjs.e;
      label227:
      ((TextView)localObject1).setText(NativeShareView.a((String)localObject2, paramInt));
      paramInt = -16578534;
      localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramViewGroup.jdField_a_of_type_Bbjs.c) {
        break label456;
      }
      label257:
      ((TextView)localObject1).setTextColor(paramInt);
      if (!paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Boolean) {
        break label520;
      }
      if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label462;
      }
      localObject1 = paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label292:
      paramInt = ((Drawable)localObject1).getIntrinsicWidth();
      int j = ((Drawable)localObject1).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= paramInt) {
        break label481;
      }
      paramInt = (int)((this.jdField_a_of_type_Int - paramInt) / 2.0F);
      label324:
      if (this.jdField_a_of_type_Int > j) {
        i = (int)((this.jdField_a_of_type_Int - j) / 2.0F);
      }
      localObject1 = this.jdField_a_of_type_Pni.a((Drawable)localObject1, paramInt, i);
      if (!paramViewGroup.jdField_a_of_type_Bbjs.c) {
        break label486;
      }
      localObject2 = pni.a(this.jdField_a_of_type_Pni, (Drawable)localObject1);
      localObject1 = this.jdField_a_of_type_Pni.a((Drawable)localObject1, (Drawable)localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      label403:
      if (Build.VERSION.SDK_INT < 16) {
        break label509;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      label419:
      if (!AppSetting.d) {
        break label596;
      }
      if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_JavaLangString == null) {
        break label598;
      }
    }
    label456:
    label462:
    label596:
    label598:
    for (paramViewGroup = paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_JavaLangString;; paramViewGroup = "")
    {
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramInt = 6;
      break label227;
      paramInt = 2130905114;
      break label257;
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Int);
      break label292;
      label481:
      paramInt = 0;
      break label324;
      label486:
      localObject1 = pni.b(this.jdField_a_of_type_Pni, (Drawable)localObject1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label403;
      label509:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      break label419;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837550);
      if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label419;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        break label419;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Int);
      break label419;
      break;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pnh
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewCompat;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class mna
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<mnk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public mna(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.b = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.jdField_a_of_type_Int = AIOUtils.dp2px(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private BitmapDrawable a(String paramString)
  {
    Object localObject = null;
    if (0 == 0)
    {
      localObject = VideoController.a().a();
      if ((((lfe)localObject).d != 1) && (((lfe)localObject).d != 2)) {
        break label71;
      }
    }
    label71:
    for (int i = 1; i != 0; i = 0)
    {
      localObject = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), ((VideoAppInterface)localObject).a(0, paramString, null, true, true));
      return localObject;
    }
    paramString = VideoController.a().a(String.valueOf(paramString), String.valueOf(((lfe)localObject).g), ((lfe)localObject).F, true, true);
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramString);
  }
  
  private View a(LayoutInflater paramLayoutInflater, int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = paramLayoutInflater.inflate(paramInt2, paramViewGroup, false);
    }
    paramLayoutInflater = a(paramInt1);
    paramView = localView.findViewById(2131368063);
    paramViewGroup = (TextView)localView.findViewById(2131378658);
    paramView.setVisibility(0);
    paramView.setBackgroundDrawable(a(paramLayoutInflater.a()));
    paramViewGroup.setPadding(AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramViewGroup.setText(paramLayoutInflater.a());
    paramViewGroup.setTextColor(-1);
    paramViewGroup.setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ViewCompat.setAccessibilityDelegate(localView, new mnb(this, paramLayoutInflater));
    return localView;
  }
  
  public mnk a(int paramInt)
  {
    return (mnk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<mnk> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      mnk.a(this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(mnk parammnk)
  {
    this.jdField_a_of_type_JavaUtilList.add(parammnk);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = a(this.jdField_a_of_type_AndroidViewLayoutInflater, paramInt, paramView, paramViewGroup, 2131559815);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mna
 * JD-Core Version:    0.7.0.1
 */
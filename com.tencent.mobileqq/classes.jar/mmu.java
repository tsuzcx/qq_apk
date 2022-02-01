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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class mmu
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<mne> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public mmu(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.b = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.jdField_a_of_type_Int = agej.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private BitmapDrawable a(String paramString)
  {
    Object localObject = null;
    if (0 == 0)
    {
      localObject = VideoController.a().a();
      if ((((lff)localObject).d != 1) && (((lff)localObject).d != 2)) {
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
    paramString = VideoController.a().a(String.valueOf(paramString), String.valueOf(((lff)localObject).g), ((lff)localObject).F, true, true);
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramString);
  }
  
  private View a(LayoutInflater paramLayoutInflater, int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = paramLayoutInflater.inflate(paramInt2, paramViewGroup, false);
    }
    paramLayoutInflater = a(paramInt1);
    paramView = localView.findViewById(2131367895);
    paramViewGroup = (TextView)localView.findViewById(2131378603);
    paramView.setVisibility(0);
    paramView.setBackgroundDrawable(a(paramLayoutInflater.a()));
    paramViewGroup.setPadding(agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramViewGroup.setText(paramLayoutInflater.a());
    paramViewGroup.setTextColor(-1);
    paramViewGroup.setSpannableFactory(begp.a);
    ViewCompat.setAccessibilityDelegate(localView, new mmv(this, paramLayoutInflater));
    return localView;
  }
  
  public mne a(int paramInt)
  {
    return (mne)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<mne> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      mne.a(this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(mne parammne)
  {
    this.jdField_a_of_type_JavaUtilList.add(parammne);
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
    View localView = a(this.jdField_a_of_type_AndroidViewLayoutInflater, paramInt, paramView, paramViewGroup, 2131559776);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmu
 * JD-Core Version:    0.7.0.1
 */
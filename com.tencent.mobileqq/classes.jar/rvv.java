import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rvv
  extends rvw
{
  public rvv(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public boolean a()
  {
    return getCount() == 5;
  }
  
  public boolean a(@NonNull TagInfo paramTagInfo)
  {
    int i = getCount();
    super.a(paramTagInfo);
    return i != getCount();
  }
  
  @NonNull
  public View getView(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    localView.setSelected(true);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvv
 * JD-Core Version:    0.7.0.1
 */
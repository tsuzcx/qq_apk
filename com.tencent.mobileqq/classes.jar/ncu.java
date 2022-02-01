import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.Pair;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;

public class ncu
  extends RecyclerView.Adapter<ncv>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  ArrayList<SurvivalPkResultInfo.Pair<Integer, Long>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private ndl jdField_a_of_type_Ndl;
  private boolean jdField_a_of_type_Boolean;
  
  public ncu(Context paramContext, ArrayList<SurvivalPkResultInfo.Pair<Integer, Long>> paramArrayList, int paramInt, HashMap<String, String> paramHashMap, ndl paramndl)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Ndl = paramndl;
  }
  
  public SurvivalPkResultInfo.Pair<Integer, Long> a(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt >= 0)) {
      return (SurvivalPkResultInfo.Pair)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ArrayList<SurvivalPkResultInfo.Pair<Integer, Long>> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ncv a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558748, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558752, paramViewGroup, false)) {
      return new ncv(paramViewGroup);
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    notifyDataSetChanged();
  }
  
  public void a(ncv paramncv, int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramncv, paramInt, getItemId(paramInt));
      return;
    }
    Bitmap localBitmap = this.jdField_a_of_type_Ndl.a(String.valueOf(((SurvivalPkResultInfo.Pair)localObject).second), (byte)1);
    ncv.a(paramncv).setImageBitmap(localBitmap);
    ncv.a(paramncv).setTypeface(AVGameText.a());
    ncv.a(paramncv).setText(String.valueOf(((SurvivalPkResultInfo.Pair)localObject).first));
    localBitmap = nqf.a("avgame_pk_result_rank_num@2x.png");
    if (localBitmap != null) {
      ncv.a(paramncv).setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(((SurvivalPkResultInfo.Pair)localObject).second));
    ncv.b(paramncv).setText((CharSequence)localObject);
    float f = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localObject = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { 1712460323, 1713576244 });
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i == 1) {
      ((GradientDrawable)localObject).setCornerRadius(f);
    }
    for (;;)
    {
      ncv.a(paramncv).setBackgroundDrawable((Drawable)localObject);
      break;
      if ((i > 1) && (paramInt == 0)) {
        ((GradientDrawable)localObject).setCornerRadii(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      } else if ((i > 1) && (paramInt == i - 1)) {
        ((GradientDrawable)localObject).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
      } else {
        ((GradientDrawable)localObject).setCornerRadius(0.0F);
      }
    }
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size();; i = this.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GamePKResultRankAdapter", 2, "getItemCount size: " + i);
      }
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncu
 * JD-Core Version:    0.7.0.1
 */
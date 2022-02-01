import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class myb
  extends atab
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new myc(this);
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, ArrayList<myd>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private myf jdField_a_of_type_Myf;
  
  public myb(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, myf parammyf)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Myf = parammyf;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    Object localObject3 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    Object localObject4;
    if (localObject3 != null)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (myd)((Iterator)localObject3).next();
        if (((myd)localObject4).jdField_a_of_type_Int != paramInt2) {
          break label804;
        }
        localObject1 = (FileManagerEntity)getChild(paramInt1, ((myd)localObject4).jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        return paramView;
      }
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          localObject3 = new mye();
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560813, paramViewGroup, false);
          paramView = paramViewGroup;
          paramViewGroup = paramView;
        }
        catch (Exception paramViewGroup)
        {
          String str;
          SpannableStringBuilder localSpannableStringBuilder;
          continue;
        }
        try
        {
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376268));
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject3);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370786);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366755));
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366742));
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject3);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366753));
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366740));
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.dp2px(70.0F, this.b.getResources()), AIOUtils.dp2px(70.0F, this.b.getResources()));
          paramViewGroup = paramView;
          paramView.setTag(localObject3);
          paramViewGroup = paramView;
          auea.a(((mye)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject1).strThumbPath, 2);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_Int = paramInt1;
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_b_of_type_Int = paramInt2;
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          paramViewGroup = paramView;
          if (!auea.a(this.b, (FileManagerEntity)localObject1)) {
            continue;
          }
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_JavaLangObject = localObject1;
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetTextView.setText(((FileManagerEntity)localObject1).fileName);
          paramViewGroup = paramView;
          if (5 != ((FileManagerEntity)localObject1).cloudType)
          {
            paramViewGroup = paramView;
            auea.b((FileManagerEntity)localObject1);
          }
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((FileManagerEntity)localObject1).Uuid.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString));
          paramViewGroup = paramView;
          localObject4 = (LinearLayout.LayoutParams)((mye)localObject3).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          paramViewGroup = paramView;
          ((LinearLayout.LayoutParams)localObject4).topMargin = AIOUtils.dp2px(3.0F, this.b.getResources());
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.b.getResources().getDisplayMetrics()), 1.0F);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.b.getResources().getDisplayMetrics()), 1.0F);
          paramViewGroup = paramView;
          localObject4 = bgke.a(((FileManagerEntity)localObject1).fileSize);
          paramViewGroup = paramView;
          str = bfif.a(BaseApplicationImpl.getApplication(), ((FileManagerEntity)localObject1).srvTime);
          paramViewGroup = paramView;
          localObject1 = ((FileManagerEntity)localObject1).peerNick;
          paramViewGroup = paramView;
          localSpannableStringBuilder = new SpannableStringBuilder();
          paramViewGroup = paramView;
          localSpannableStringBuilder.append(str).append("  ").append("来自").append((CharSequence)localObject1).append("  ").append((CharSequence)localObject4);
          paramViewGroup = paramView;
          ((mye)localObject3).jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
        }
        catch (Exception localException)
        {
          paramView = paramViewGroup;
          paramViewGroup = localException;
          paramViewGroup.printStackTrace();
          continue;
        }
        return paramView;
        localObject3 = (mye)paramView.getTag();
        continue;
        paramViewGroup = paramView;
        ((mye)localObject3).jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup = paramView;
        ((mye)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      label804:
      break;
      Object localObject2 = null;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    Object localObject1 = a(paramInt);
    if (localObject1 != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      int j = 0;
      i = 0;
      if (localIterator.hasNext())
      {
        Object localObject2 = (FileManagerEntity)localIterator.next();
        int k;
        if ((((FileManagerEntity)localObject2).getCloudType() == 0) || ((((FileManagerEntity)localObject2).getCloudType() == 5) && (!((FileManagerEntity)localObject2).bSend) && (((FileManagerEntity)localObject2).status != 1)))
        {
          k = j + 1;
          j = i;
          i = k;
        }
        for (;;)
        {
          k = j;
          j = i;
          i = k;
          break;
          if (((FileManagerEntity)localObject2).sendCloudUnsuccessful())
          {
            k = j + 1;
            j = i;
            i = k;
          }
          else
          {
            localObject2 = new myd();
            ((myd)localObject2).jdField_a_of_type_Int = i;
            ((myd)localObject2).jdField_b_of_type_Int = (i + j);
            localArrayList.add(localObject2);
            k = i + 1;
            i = j;
            j = k;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
      i = ((ArrayList)localObject1).size() - j;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myb
 * JD-Core Version:    0.7.0.1
 */
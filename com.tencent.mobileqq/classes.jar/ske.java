import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class ske
  extends abil<TabChannelCoverInfo>
{
  public static final String a;
  private Map<Integer, qvp> jdField_a_of_type_JavaUtilMap;
  private ohp jdField_a_of_type_Ohp;
  private TabLayout b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ske.class.getSimpleName();
  }
  
  public ske(Context paramContext, List<TabChannelCoverInfo> paramList, TabLayout paramTabLayout, ohp paramohp)
  {
    super(paramContext, paramList);
    this.b = paramTabLayout;
    this.jdField_a_of_type_Ohp = paramohp;
  }
  
  private void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(8);
      i += 1;
    }
  }
  
  private int b()
  {
    if (paz.a()) {
      return 11;
    }
    return 6;
  }
  
  protected int a()
  {
    return 2131560219;
  }
  
  protected void a(abim paramabim, TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    TextView localTextView = (TextView)paramabim.a(2131380141);
    Object localObject2 = (ImageView)paramabim.a(2131369247);
    ImageView localImageView2 = (ImageView)paramabim.a(2131369250);
    Object localObject1 = (ImageView)paramabim.a(2131371755);
    a(new View[] { localTextView, localObject2, localImageView2, localObject1 });
    ImageView localImageView1 = (ImageView)paramabim.a(2131369353);
    if (paramTabChannelCoverInfo != null)
    {
      if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelCoverPicUrl))
      {
        localImageView2.setVisibility(0);
        localImageView2.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo.mChannelCoverPicUrl, true));
      }
      if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mIconUrl)) {
        ((ImageView)localObject2).setVisibility(0);
      }
    }
    label778:
    try
    {
      ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo.mIconUrl, true));
      if ((!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelCoverName)) && (paramTabChannelCoverInfo.onlyCover == 0))
      {
        localTextView.setText(paramTabChannelCoverInfo.mChannelCoverName);
        if (paramTabChannelCoverInfo.fontsColor != 0)
        {
          i = paramTabChannelCoverInfo.fontsColor;
          localTextView.setTextColor(i);
          localTextView.setVisibility(0);
        }
      }
      else
      {
        if (paramTabChannelCoverInfo.redPoint == null) {
          break label761;
        }
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        if (!paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean) {
          break label744;
        }
        long l = System.currentTimeMillis() / 1000L;
        if ((paramTabChannelCoverInfo.redPoint.c == 0L) || ((float)(l - paramTabChannelCoverInfo.redPoint.c) <= 2.5F) || ((float)(l / 3600L - paramTabChannelCoverInfo.redPoint.c / 3600L) >= 1.0F)) {
          break label615;
        }
        i = 1;
        if ((paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Long > l) || ((paramTabChannelCoverInfo.redPoint.b != 0L) && (paramTabChannelCoverInfo.redPoint.b < l))) {
          break label727;
        }
        if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Int != 0) {
          break label621;
        }
        localImageView1.setVisibility(0);
        paramabim.a().setOnClickListener(new skf(this, paramInt, paramTabChannelCoverInfo, localImageView1));
        if (this.b != null)
        {
          i = this.b.getFirstVisiblePosition();
          int j = this.b.getLastVisiblePosition();
          if ((paramInt >= i) && (paramInt <= j) && (this.jdField_a_of_type_JavaUtilMap != null))
          {
            localObject1 = new qwz();
            ((qvp)localObject1).a = paramTabChannelCoverInfo;
            ((qvp)localObject1).l = paramInt;
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), localObject1);
          }
        }
        if (this.jdField_a_of_type_Ohp != null)
        {
          paramabim = paramabim.a(2131368931);
          if (paramInt != this.jdField_a_of_type_Ohp.c()) {
            break label778;
          }
          localTextView.setTextColor(localTextView.getResources().getColor(2131166883));
          localTextView.setTypeface(Typeface.defaultFromStyle(1));
          paramabim.setVisibility(0);
          if (this.jdField_a_of_type_Ohp.a() == 0)
          {
            paramTabChannelCoverInfo = (ViewGroup.MarginLayoutParams)paramabim.getLayoutParams();
            paramTabChannelCoverInfo.leftMargin = bhtq.b(0.0F);
            paramTabChannelCoverInfo.rightMargin = bhtq.b(0.0F);
            paramabim.setLayoutParams(paramTabChannelCoverInfo);
          }
        }
        return;
      }
    }
    catch (Exception localException)
    {
      label727:
      for (;;)
      {
        int i;
        label615:
        label744:
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "load channel cover error : " + localException);
          continue;
          i = -16777216;
          continue;
          i = 0;
          continue;
          label621:
          if ((paramInt < b()) && (i == 0))
          {
            if (ohp.b)
            {
              ((ImageView)localObject1).setVisibility(0);
              TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 1.0F, 1, -1.0F, 1, -1.0F, 1, 1.0F);
              localTranslateAnimation.setDuration(3000L);
              localTranslateAnimation.setRepeatCount(1);
              localTranslateAnimation.setStartOffset(1000L);
              localTranslateAnimation.setFillAfter(true);
              ((ImageView)localObject1).startAnimation(localTranslateAnimation);
            }
            paramTabChannelCoverInfo.redPoint.c = (System.currentTimeMillis() / 1000L);
            this.jdField_a_of_type_Ohp.a(paramTabChannelCoverInfo);
            continue;
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            label761:
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            localTextView.setTextColor(localTextView.getResources().getColor(2131166884));
            localTextView.setTypeface(Typeface.defaultFromStyle(0));
            paramabim.setVisibility(4);
          }
        }
      }
    }
  }
  
  public void a(Map<Integer, qvp> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ske
 * JD-Core Version:    0.7.0.1
 */
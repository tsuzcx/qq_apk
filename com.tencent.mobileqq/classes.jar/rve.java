import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
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

public class rve
  extends zhn<TabChannelCoverInfo>
{
  public static final String a;
  private Map<Integer, qkk> jdField_a_of_type_JavaUtilMap;
  private nwm jdField_a_of_type_Nwm;
  private TabLayout b;
  
  static
  {
    jdField_a_of_type_JavaLangString = rve.class.getSimpleName();
  }
  
  public rve(Context paramContext, List<TabChannelCoverInfo> paramList, TabLayout paramTabLayout, nwm paramnwm)
  {
    super(paramContext, paramList);
    this.b = paramTabLayout;
    this.jdField_a_of_type_Nwm = paramnwm;
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
    if (otb.a()) {
      return 11;
    }
    return 6;
  }
  
  protected int a()
  {
    return 2131560064;
  }
  
  public void a(Map<Integer, qkk> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  protected void a(zho paramzho, TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    TextView localTextView = (TextView)paramzho.a(2131379043);
    Object localObject2 = (ImageView)paramzho.a(2131368809);
    ImageView localImageView2 = (ImageView)paramzho.a(2131368812);
    Object localObject1 = (ImageView)paramzho.a(2131371086);
    a(new View[] { localTextView, localObject2, localImageView2, localObject1 });
    ImageView localImageView1 = (ImageView)paramzho.a(2131368897);
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
    try
    {
      ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo.mIconUrl, true));
      if ((!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelCoverName)) && (paramTabChannelCoverInfo.only_cover == 0))
      {
        localTextView.setText(paramTabChannelCoverInfo.mChannelCoverName);
        if (paramTabChannelCoverInfo.fonts_color != 0)
        {
          i = paramTabChannelCoverInfo.fonts_color;
          localTextView.setTextColor(i);
          localTextView.setVisibility(0);
        }
      }
      else
      {
        if (paramTabChannelCoverInfo.redPoint == null) {
          break label767;
        }
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        if (!paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean) {
          break label750;
        }
        long l = System.currentTimeMillis() / 1000L;
        if ((paramTabChannelCoverInfo.redPoint.c == 0L) || ((float)(l - paramTabChannelCoverInfo.redPoint.c) <= 2.5F) || ((float)(l / 3600L - paramTabChannelCoverInfo.redPoint.c / 3600L) >= 1.0F)) {
          break label615;
        }
        i = 1;
        if ((paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Long > l) || ((paramTabChannelCoverInfo.redPoint.b != 0L) && (paramTabChannelCoverInfo.redPoint.b < l))) {
          break label733;
        }
        if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Int != 0) {
          break label621;
        }
        localImageView1.setVisibility(0);
        paramzho.a().setOnClickListener(new rvf(this, paramInt, paramTabChannelCoverInfo, localImageView1));
        if (this.b != null)
        {
          i = this.b.getFirstVisiblePosition();
          int j = this.b.getLastVisiblePosition();
          if ((paramInt >= i) && (paramInt <= j) && (this.jdField_a_of_type_JavaUtilMap != null))
          {
            localObject1 = new qlu();
            ((qkk)localObject1).a = paramTabChannelCoverInfo;
            ((qkk)localObject1).l = paramInt;
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), localObject1);
          }
        }
        if (this.jdField_a_of_type_Nwm != null)
        {
          paramzho = paramzho.a(2131368530);
          if (paramInt != this.jdField_a_of_type_Nwm.c()) {
            break label784;
          }
          localTextView.setTextColor(localTextView.getResources().getColor(2131166799));
          localTextView.setTypeface(Typeface.defaultFromStyle(1));
          paramzho.setVisibility(0);
          if (this.jdField_a_of_type_Nwm.a() == 0)
          {
            paramTabChannelCoverInfo = (ViewGroup.MarginLayoutParams)paramzho.getLayoutParams();
            paramTabChannelCoverInfo.leftMargin = bdoo.b(0.0F);
            paramTabChannelCoverInfo.rightMargin = bdoo.b(0.0F);
            paramzho.setLayoutParams(paramTabChannelCoverInfo);
          }
        }
        return;
      }
    }
    catch (Exception localException)
    {
      label784:
      for (;;)
      {
        int i;
        label733:
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "load channel cover error : " + localException);
          continue;
          i = -16777216;
          continue;
          label615:
          i = 0;
          continue;
          label621:
          if ((paramInt < b()) && (i == 0))
          {
            Object localObject3 = this.jdField_a_of_type_Nwm;
            if (nwm.b)
            {
              ((ImageView)localObject1).setVisibility(0);
              localObject3 = new TranslateAnimation(1, 1.0F, 1, -1.0F, 1, -1.0F, 1, 1.0F);
              ((TranslateAnimation)localObject3).setDuration(3000L);
              ((TranslateAnimation)localObject3).setRepeatCount(1);
              ((TranslateAnimation)localObject3).setStartOffset(1000L);
              ((TranslateAnimation)localObject3).setFillAfter(true);
              ((ImageView)localObject1).startAnimation((Animation)localObject3);
            }
            paramTabChannelCoverInfo.redPoint.c = (System.currentTimeMillis() / 1000L);
            this.jdField_a_of_type_Nwm.a(paramTabChannelCoverInfo);
            continue;
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            label750:
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            label767:
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            localTextView.setTextColor(localTextView.getResources().getColor(2131166800));
            localTextView.setTypeface(Typeface.defaultFromStyle(0));
            paramzho.setVisibility(4);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rve
 * JD-Core Version:    0.7.0.1
 */
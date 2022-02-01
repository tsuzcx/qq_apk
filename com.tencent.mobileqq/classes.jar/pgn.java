import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class pgn
{
  private bjrb jdField_a_of_type_Bjrb;
  private bjrh jdField_a_of_type_Bjrh;
  private tch jdField_a_of_type_Tch;
  
  public bjrb a(Context paramContext)
  {
    if (this.jdField_a_of_type_Bjrb == null) {
      this.jdField_a_of_type_Bjrb = new bjrb(paramContext);
    }
    return this.jdField_a_of_type_Bjrb;
  }
  
  public bjrh a(Context paramContext)
  {
    if (this.jdField_a_of_type_Bjrh == null) {
      this.jdField_a_of_type_Bjrh = new bjrh(paramContext);
    }
    return this.jdField_a_of_type_Bjrh;
  }
  
  public tch a(Activity paramActivity, slt paramslt)
  {
    if (this.jdField_a_of_type_Tch == null) {
      this.jdField_a_of_type_Tch = new tch(paramActivity, paramslt);
    }
    return this.jdField_a_of_type_Tch;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bjrb = null;
    this.jdField_a_of_type_Bjrh = null;
  }
  
  public void a(View paramView, skb paramskb, BaseArticleInfo paramBaseArticleInfo, ped paramped)
  {
    int i = paramskb.a;
    paramskb = new pgo(this, i, paramped, paramskb, paramBaseArticleInfo);
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      if ((this.jdField_a_of_type_Bjrb != null) && (this.jdField_a_of_type_Bjrb.isShowing())) {
        this.jdField_a_of_type_Bjrb.dismiss();
      }
      this.jdField_a_of_type_Bjrh.a(i, paramped.a().b(), pay.a(paramBaseArticleInfo), ((AdvertisementInfo)paramBaseArticleInfo).mAdDislikeInfos);
      this.jdField_a_of_type_Bjrh.a(paramView, paramskb);
      this.jdField_a_of_type_Bjrh.a(new pgq(this, paramped, paramBaseArticleInfo));
      this.jdField_a_of_type_Bjrh.setOnDismissListener(new pgr(this, paramped));
      return;
    }
    if ((this.jdField_a_of_type_Bjrh != null) && (this.jdField_a_of_type_Bjrh.isShowing())) {
      this.jdField_a_of_type_Bjrh.dismiss();
    }
    this.jdField_a_of_type_Bjrb.a(i, paramped.a().b(), pay.a(paramBaseArticleInfo), paramBaseArticleInfo.mDislikeInfos, paramBaseArticleInfo.innerUniqueID);
    this.jdField_a_of_type_Bjrb.a(paramView, paramskb);
    this.jdField_a_of_type_Bjrb.setOnDismissListener(new pgs(this, paramped));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgn
 * JD-Core Version:    0.7.0.1
 */
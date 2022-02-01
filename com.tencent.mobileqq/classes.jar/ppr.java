import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ppr
{
  private blcn jdField_a_of_type_Blcn;
  private blct jdField_a_of_type_Blct;
  private tps jdField_a_of_type_Tps;
  
  public static String a(ArrayList<DislikeInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return "";
    }
    localJSONArray = new JSONArray();
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", localDislikeInfo.jdField_a_of_type_Int);
        localJSONObject.put("name", localDislikeInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("tagid", localDislikeInfo.jdField_a_of_type_Long);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray.toString();
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public blcn a(Context paramContext)
  {
    if (this.jdField_a_of_type_Blcn == null) {
      this.jdField_a_of_type_Blcn = new blcn(paramContext);
    }
    return this.jdField_a_of_type_Blcn;
  }
  
  public blct a(Context paramContext)
  {
    if (this.jdField_a_of_type_Blct == null) {
      this.jdField_a_of_type_Blct = new blct(paramContext);
    }
    return this.jdField_a_of_type_Blct;
  }
  
  public tps a(Activity paramActivity, szd paramszd)
  {
    if (this.jdField_a_of_type_Tps == null) {
      this.jdField_a_of_type_Tps = new tps(paramActivity, paramszd);
    }
    return this.jdField_a_of_type_Tps;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blcn = null;
    this.jdField_a_of_type_Blct = null;
  }
  
  public void a(View paramView, sxl paramsxl, BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    int i = paramsxl.jdField_a_of_type_Int;
    paramsxl = new pps(this, i, parampne, paramsxl, paramBaseArticleInfo);
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      if ((this.jdField_a_of_type_Blcn != null) && (this.jdField_a_of_type_Blcn.isShowing())) {
        this.jdField_a_of_type_Blcn.dismiss();
      }
      this.jdField_a_of_type_Blct.a(i, parampne.a().b(), pqw.a(paramBaseArticleInfo), ((AdvertisementInfo)paramBaseArticleInfo).mAdDislikeInfos);
      this.jdField_a_of_type_Blct.a(paramView, paramsxl);
      this.jdField_a_of_type_Blct.a(new ppu(this, parampne, paramBaseArticleInfo));
      this.jdField_a_of_type_Blct.setOnDismissListener(new ppv(this, parampne));
      return;
    }
    if ((this.jdField_a_of_type_Blct != null) && (this.jdField_a_of_type_Blct.isShowing())) {
      this.jdField_a_of_type_Blct.dismiss();
    }
    this.jdField_a_of_type_Blcn.a(i, parampne.a().b(), pqw.a(paramBaseArticleInfo), paramBaseArticleInfo.mDislikeInfos, paramBaseArticleInfo.innerUniqueID);
    this.jdField_a_of_type_Blcn.a(paramView, paramsxl);
    this.jdField_a_of_type_Blcn.setOnDismissListener(new ppw(this, parampne));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppr
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tfy
  extends JobSegment<tfi, List<tsr>>
{
  public String a;
  public txc a;
  public boolean a;
  public String b = "";
  public String c;
  
  public tfy(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.c = paramString;
  }
  
  public tfy(String paramString1, String paramString2, String paramString3, txc paramtxc)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Txc = paramtxc;
  }
  
  public static List<tsr> a(List<tga> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tga localtga = (tga)paramList.next();
      if ((!TextUtils.isEmpty(localtga.b)) && (!TextUtils.isEmpty(localtga.jdField_a_of_type_JavaLangString)))
      {
        tsr localtsr = new tsr();
        localtsr.jdField_a_of_type_JavaLangString = localtga.b;
        localtsr.b = localtga.jdField_a_of_type_JavaLangString;
        localtsr.jdField_a_of_type_Long = localtga.jdField_a_of_type_Long;
        localtsr.jdField_a_of_type_Boolean = localtga.jdField_a_of_type_Boolean;
        localArrayList.add(localtsr);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, tfi paramtfi)
  {
    if (paramtfi == null)
    {
      veg.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      vxs.a("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    veg.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramtfi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Txc, Integer.valueOf(paramtfi.jdField_a_of_type_JavaUtilList.size()), paramtfi.k });
    if (TextUtils.isEmpty(paramtfi.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramtfi.jdField_a_of_type_JavaUtilList.size() == 0) && (paramtfi.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramtfi });
      }
      if (paramtfi.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramtfi.a()) && (paramtfi.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramtfi });
      }
      notifyResult(a(paramtfi.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramtfi.jdField_a_of_type_Int != 12) {
      paramJobContext = tgb.a(paramtfi);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramtfi);
      }
      veg.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = tgo.a(paramtfi, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        veg.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      veg.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      veg.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_Txc != null) && (this.jdField_a_of_type_Txc.jdField_a_of_type_Boolean))
    {
      veg.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    veg.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new tgo(paramtfi, this.jdField_a_of_type_JavaLangString, this.b);
    veg.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramtfi.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      veg.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramtfi.jdField_a_of_type_JavaUtilList.clear();
    }
    syr.a().a(paramJobContext, new tfz(this, paramtfi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfy
 * JD-Core Version:    0.7.0.1
 */
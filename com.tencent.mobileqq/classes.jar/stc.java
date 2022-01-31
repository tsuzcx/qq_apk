import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class stc
  extends JobSegment<ssm, List<tfv>>
{
  public String a;
  public tkg a;
  public boolean a;
  public String b = "";
  public String c;
  
  public stc(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.c = paramString;
  }
  
  public stc(String paramString1, String paramString2, String paramString3, tkg paramtkg)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Tkg = paramtkg;
  }
  
  public static List<tfv> a(List<ste> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ste localste = (ste)paramList.next();
      if ((!TextUtils.isEmpty(localste.b)) && (!TextUtils.isEmpty(localste.jdField_a_of_type_JavaLangString)))
      {
        tfv localtfv = new tfv();
        localtfv.jdField_a_of_type_JavaLangString = localste.b;
        localtfv.b = localste.jdField_a_of_type_JavaLangString;
        localtfv.jdField_a_of_type_Long = localste.jdField_a_of_type_Long;
        localtfv.jdField_a_of_type_Boolean = localste.jdField_a_of_type_Boolean;
        localArrayList.add(localtfv);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, ssm paramssm)
  {
    if (paramssm == null)
    {
      urk.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      vkw.a("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    urk.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramssm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Tkg, Integer.valueOf(paramssm.jdField_a_of_type_JavaUtilList.size()), paramssm.k });
    if (TextUtils.isEmpty(paramssm.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramssm.jdField_a_of_type_JavaUtilList.size() == 0) && (paramssm.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramssm });
      }
      if (paramssm.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramssm.a()) && (paramssm.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramssm });
      }
      notifyResult(a(paramssm.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramssm.jdField_a_of_type_Int != 12) {
      paramJobContext = stf.a(paramssm);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramssm);
      }
      urk.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = sts.a(paramssm, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        urk.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      urk.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      urk.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_Tkg != null) && (this.jdField_a_of_type_Tkg.jdField_a_of_type_Boolean))
    {
      urk.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    urk.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new sts(paramssm, this.jdField_a_of_type_JavaLangString, this.b);
    urk.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramssm.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      urk.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramssm.jdField_a_of_type_JavaUtilList.clear();
    }
    slv.a().a(paramJobContext, new std(this, paramssm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stc
 * JD-Core Version:    0.7.0.1
 */
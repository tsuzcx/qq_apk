import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.ModuleInfo;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.TextCardInfo;

public class rjc
  extends osm
{
  public rjc(FastWebActivity paramFastWebActivity) {}
  
  public void a(ArrayList<String> paramArrayList, List<oidb_cmd0xc6d.ModuleInfo> paramList, List<oidb_cmd0xc6d.TextCardInfo> paramList1)
  {
    Object localObject = rmr.a(23, paramArrayList);
    if (FastWebActivity.a(this.a) != null) {}
    for (paramArrayList = FastWebActivity.a(this.a).innerUniqueID;; paramArrayList = "")
    {
      if ((TextUtils.isEmpty(paramArrayList)) || (FastWebActivity.a(this.a) == null)) {}
      do
      {
        return;
        int i = 0;
        while (i < ((List)localObject).size())
        {
          BaseData localBaseData = (BaseData)((List)localObject).get(i);
          if ((localBaseData instanceof ProteusItemData)) {
            rmr.a(FastWebActivity.a(this.a), (ProteusItemData)localBaseData, 3, this.a.a);
          }
          rnj.b(FastWebActivity.a(this.a), localBaseData, FastWebActivity.a(this.a));
          i += 1;
        }
        localObject = osg.a().a();
        if (localObject != null) {
          ((paf)localObject).a(paramArrayList, FastWebActivity.a(this.a));
        }
        if (paramList != null) {
          rme.a(FastWebActivity.a(this.a), FastWebActivity.a(this.a), FastWebActivity.a(this.a), paramList, FastWebActivity.a(this.a), this.a.a);
        }
        if (paramList1 != null) {
          rme.b(FastWebActivity.a(this.a), FastWebActivity.a(this.a), FastWebActivity.a(this.a), paramList1, FastWebActivity.a(this.a), this.a.a);
        }
      } while (FastWebActivity.a(this.a) == null);
      FastWebActivity.a(this.a).notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjc
 * JD-Core Version:    0.7.0.1
 */
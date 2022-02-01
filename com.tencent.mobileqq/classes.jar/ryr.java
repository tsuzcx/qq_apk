import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.AddVideoReq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.MoveVideoReq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.ReqBody;

public class ryr
{
  public static void a(List<String> paramList, int paramInt, @Nullable ryu paramryu)
  {
    oidb_0xe2a.MoveVideoReq localMoveVideoReq = new oidb_0xe2a.MoveVideoReq();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(str)) {
        localMoveVideoReq.rpt_rowkey_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    localMoveVideoReq.uint32_column_id.set(paramInt);
    localMoveVideoReq.uint32_oper_type.set(1);
    paramList = new oidb_0xe2a.ReqBody();
    paramList.msg_move_video_req.set(localMoveVideoReq);
    ntb.a(pnn.a(), new ryt(paramryu, paramInt), paramList.toByteArray(), "OidbSvc.0xe2a", 3626, 2);
  }
  
  public static void a(boolean paramBoolean, List<UgcVideo> paramList, @Nullable ryv paramryv)
  {
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((List)localObject).add(((UgcVideo)paramList.next()).parseUgcVideo());
    }
    paramList = new oidb_0xe2a.ReqBody();
    oidb_0xe2a.AddVideoReq localAddVideoReq = new oidb_0xe2a.AddVideoReq();
    localAddVideoReq.rpt_video_list.set((List)localObject);
    localObject = localAddVideoReq.uint32_add_video_type;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      ((PBUInt32Field)localObject).set(i);
      paramList.msg_add_video_req.set(localAddVideoReq);
      ntb.a(pnn.a(), new rys(paramryv), paramList.toByteArray(), "OidbSvc.0xe2a", 3626, 1, null, 120000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryr
 * JD-Core Version:    0.7.0.1
 */
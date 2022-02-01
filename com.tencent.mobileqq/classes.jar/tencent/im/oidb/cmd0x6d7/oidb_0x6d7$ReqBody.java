package tencent.im.oidb.cmd0x6d7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6d7$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "create_folder_req", "delete_folder_req", "rename_folder_req", "move_folder_req" }, new Object[] { null, null, null, null }, ReqBody.class);
  public oidb_0x6d7.CreateFolderReqBody create_folder_req = new oidb_0x6d7.CreateFolderReqBody();
  public oidb_0x6d7.DeleteFolderReqBody delete_folder_req = new oidb_0x6d7.DeleteFolderReqBody();
  public oidb_0x6d7.MoveFolderReqBody move_folder_req = new oidb_0x6d7.MoveFolderReqBody();
  public oidb_0x6d7.RenameFolderReqBody rename_folder_req = new oidb_0x6d7.RenameFolderReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d7.oidb_0x6d7.ReqBody
 * JD-Core Version:    0.7.0.1
 */
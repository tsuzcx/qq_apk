package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class OlympicTorchSvc$RspGetBusinessTorch
  extends MessageMicro<RspGetBusinessTorch>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_rsp_head", "msg_torch_info", "msg_scene_wording" }, new Object[] { null, null, null }, RspGetBusinessTorch.class);
  public OlympicTorchSvc.RspHead msg_rsp_head = new OlympicTorchSvc.RspHead();
  public OlympicTorchSvc.SceneWording msg_scene_wording = new OlympicTorchSvc.SceneWording();
  public torch_transfer.TorchbearerInfo msg_torch_info = new torch_transfer.TorchbearerInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.olympic.OlympicTorchSvc.RspGetBusinessTorch
 * JD-Core Version:    0.7.0.1
 */
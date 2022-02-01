package dov.com.qq.im.ae.play;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class AEVideoShelfEditFragment$12
  extends AsyncTask<Void, Void, Void>
{
  AEVideoShelfEditFragment$12(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = new Intent();
    paramVarArgs.putExtra("from", true);
    paramVarArgs.putExtra("isNeedEditButton", true);
    paramVarArgs.putExtra("usePagPreview", true);
    paramVarArgs.putExtra("videoOutWidth", AEVideoShelfEditFragment.access$100(this.this$0).getVideoWidth());
    paramVarArgs.putExtra("videoOutHeight", AEVideoShelfEditFragment.access$100(this.this$0).getVideoHeight());
    paramVarArgs.putExtra("pagFilePath", AEVideoShelfEditFragment.access$100(this.this$0).getPagFilePath());
    paramVarArgs.putExtra("audioFilePath", AEVideoShelfEditFragment.access$100(this.this$0).getAudioPath());
    paramVarArgs.putExtra("MaterialPath", AEVideoShelfEditFragment.access$1900(this.this$0));
    paramVarArgs.putExtra("MaterialId", AEVideoShelfEditFragment.access$2000(this.this$0));
    paramVarArgs.putExtra("MaterialName", AEVideoShelfEditFragment.access$100(this.this$0).getVideoName());
    paramVarArgs.putStringArrayListExtra("PhotoList", AEVideoShelfEditFragment.access$2100(this.this$0));
    paramVarArgs.putExtra("loc_play_show_tab_name", AEVideoShelfEditFragment.access$2200(this.this$0));
    paramVarArgs.putExtra("loc_play_show_material_id", AEVideoShelfEditFragment.access$2000(this.this$0));
    paramVarArgs.putExtra("loc_play_show_take_same_name", AEVideoShelfEditFragment.access$2300(this.this$0));
    paramVarArgs.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(this.this$0.getActivity()));
    HashMap localHashMap = new HashMap();
    Object localObject = AEVideoShelfEditFragment.access$900(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((NodeGroup)((Iterator)localObject).next()).nodeItemList.iterator();
      while (localIterator.hasNext())
      {
        NodeItem localNodeItem = (NodeItem)localIterator.next();
        if (localNodeItem.type != 1) {
          localHashMap.put(AEVideoShelfEditFragment.access$2400(this.this$0, localNodeItem.nodeID, localNodeItem.cropBitmap), localNodeItem.indexLayerForPag);
        } else {
          localHashMap.put(AEVideoShelfEditFragment.access$2400(this.this$0, localNodeItem.nodeID, localNodeItem.bitmap), localNodeItem.indexLayerForPag);
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("nodeImgList", localHashMap);
    paramVarArgs.putExtras((Bundle)localObject);
    AEVideoShelfEditFragment.access$2500(this.this$0, paramVarArgs);
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    AEVideoShelfEditFragment.access$800(this.this$0);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    AEVideoShelfEditFragment.access$700(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment.12
 * JD-Core Version:    0.7.0.1
 */
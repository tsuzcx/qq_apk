package com.tencent.tkd.topicsdk.publisharticle.publish;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishStage;", "", "(Ljava/lang/String;I)V", "PUBLISH_STAGE_UPLOAD_IMAGE", "PUBLISH_STAGE_PUBLISH_VIDEO", "PUBLISH_STAGE_COMPRESS_COVER", "PUBLISH_STAGE_UPLOAD_COVER", "PUBLISH_STAGE_COMPRESS_VIDEO", "PUBLISH_STAGE_UPLOAD_VIDEO", "topicsdk_release"}, k=1, mv={1, 1, 16})
public enum PublishStage
{
  static
  {
    PublishStage localPublishStage1 = new PublishStage("PUBLISH_STAGE_UPLOAD_IMAGE", 0);
    PUBLISH_STAGE_UPLOAD_IMAGE = localPublishStage1;
    PublishStage localPublishStage2 = new PublishStage("PUBLISH_STAGE_PUBLISH_VIDEO", 1);
    PUBLISH_STAGE_PUBLISH_VIDEO = localPublishStage2;
    PublishStage localPublishStage3 = new PublishStage("PUBLISH_STAGE_COMPRESS_COVER", 2);
    PUBLISH_STAGE_COMPRESS_COVER = localPublishStage3;
    PublishStage localPublishStage4 = new PublishStage("PUBLISH_STAGE_UPLOAD_COVER", 3);
    PUBLISH_STAGE_UPLOAD_COVER = localPublishStage4;
    PublishStage localPublishStage5 = new PublishStage("PUBLISH_STAGE_COMPRESS_VIDEO", 4);
    PUBLISH_STAGE_COMPRESS_VIDEO = localPublishStage5;
    PublishStage localPublishStage6 = new PublishStage("PUBLISH_STAGE_UPLOAD_VIDEO", 5);
    PUBLISH_STAGE_UPLOAD_VIDEO = localPublishStage6;
    $VALUES = new PublishStage[] { localPublishStage1, localPublishStage2, localPublishStage3, localPublishStage4, localPublishStage5, localPublishStage6 };
  }
  
  private PublishStage() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishStage
 * JD-Core Version:    0.7.0.1
 */